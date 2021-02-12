package com.yxm.c2c.social.govern.report.controller;
import com.yxm.c2c.social.govern.report.domain.ReportTask;
import com.yxm.c2c.social.govern.report.domain.ReportTaskVote;
import com.yxm.c2c.social.govern.report.service.ReportTaskService;
import com.yxm.c2c.social.govern.report.service.ReportTaskVoteService;
import com.yxm.c2c.social.govern.reviewer.api.ReviewerService;
import com.yxm.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportTaskVoteService reportTaskVoteService;
    /**
     * 举报任务Service组件
     */
    @Autowired
    private ReportTaskService reportTaskService;

    @Reference(version = "1.0.0",
            interfaceClass = ReviewerService.class,
            cluster = "failfast")
    private ReviewerService reviewerService;

    @Reference(version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast")
    private RewardService rewardService;
    /**
     * 提交举报接口
     * @param reportTask 举报任务
     * @return
     */
    @GetMapping("/report")
    public String report(ReportTask reportTask) {
        //http://localhost:8080/report?type=1&reportUserId=1&reportContent=nihao&targetId=1&voteResult=-1
        // 封装举报任务对象
        /*reportTask.setType(type);
        reportTask.setReportUserId(reportUserId);
        reportTask.setReportContent(reportContent);
        reportTask.setTargetId(targetId);*/

        // 在本地数据库增加一个举报任务
        reportTaskService.save(reportTask);

        // 举报任务分配给评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(reportTask.getId());

        // 在本地数据库初始化这批评审员对举报任务的投票状态
        reportTaskVoteService.initVotes(reviewerIds,reportTask.getId());

        // 模拟发送push消息给评审员
        System.out.println("模拟发送push消息给评审员.....");
        return "success";
    }

    @GetMapping("/report/query/{id}")
    public ReportTask queryReportTaskId(@PathVariable("id") Long id){
     //http://localhost:8080/report/query/1
      return reportTaskService.getById(id);
    }

    /**
     * 对举报任务进行投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     * @param voteResult 投票结果
     * @return
     */
    @GetMapping("/report/vote")
    public String vote(Long reviewerId,Long reportTaskId,Integer voteResult){
        //http://localhost:8080/report/vote?reviewerId=1&reportTaskId=5&voteResult=1
        // 本地数据库记录投票
        reportTaskVoteService.vote(reviewerId,reportTaskId,voteResult);

        //通知评论服务完成评论
        reviewerService.finishVote(reviewerId,reportTaskId);

        // 对举报任务进行归票
        Boolean hasFinishedVote = reportTaskVoteService
                .calculateVotes(reportTaskId);

        // 如果举报任务得到归票结果
        if(hasFinishedVote) {
            // 发放奖励
            List<ReportTaskVote> reportTaskVotes = reportTaskVoteService
                    .getByReportTaskId(reportTaskId);
            List<Long> reviewerIds = new ArrayList<Long>();

            for(ReportTaskVote reportTaskVote : reportTaskVotes) {
                reviewerIds.add(reportTaskVote.getReviewerId());
            }
            rewardService.giveReward(reviewerIds);
            // 推送消息到MQ，告知其他系统，本次评审结果
            System.out.println("推送消息到MQ，告知其他系统，本次评审结果");
        }
        return "success";
    }
}






























