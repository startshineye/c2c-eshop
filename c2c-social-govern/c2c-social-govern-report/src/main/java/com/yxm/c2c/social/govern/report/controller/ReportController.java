package com.yxm.c2c.social.govern.report.controller;
import com.yxm.c2c.social.govern.report.domain.ReportTask;
import com.yxm.c2c.social.govern.report.service.ReportTaskService;
import com.yxm.c2c.social.govern.reviewer.api.ReviewerService;
import com.yxm.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
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
     * @param type
     * @param reportUserId
     * @param reportContent
     * @param targetId
     * @return
     */
    @GetMapping("/report")
    public String report(String type,
                         Long reportUserId,
                         String reportContent,
                         Long targetId) {
        // 封装举报任务对象
        ReportTask reportTask = new ReportTask();
        reportTask.setType(type);
        reportTask.setReportUserId(reportUserId);
        reportTask.setReportContent(reportContent);
        reportTask.setTargetId(targetId);
        // 在本地数据库增加一个举报任务
        reportTaskService.save(reportTask);
        return "success";
    }

}
