package com.yxm.c2c.social.govern.reviewer.service;

import com.yxm.c2c.social.govern.reviewer.api.ReviewerService;
import com.yxm.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.yxm.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
@Service(
        version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class ReviewerServiceImpl implements ReviewerService {

    @Value("${spring.profiles.active}")
    private String env;

    @Autowired
    private ReviewerTaskStatusDAO taskStatusDAO;

    @Override
    public List<Long> selectReviewers(Long reportTaskId) {
        System.out.println("运行环境: "+env);
        /**
         * 构建返回的reviewerIds
         * 将对应关系存放在数据库
         */
        List<Long> reviewers = new ArrayList<>();
        reviewers.add(1L);
        reviewers.add(2L);
        reviewers.add(3L);
        reviewers.add(4L);

        for(Long reviewerId:reviewers){
            ReviewerTaskStatus taskStatus = new ReviewerTaskStatus();
            taskStatus.setReportTaskId(reportTaskId);
            taskStatus.setReviewerId(reviewerId);
            taskStatus.setStatus(ReviewerTaskStatus.PROCESSING);
            taskStatusDAO.save(taskStatus);
        }
        return reviewers;
    }

    @Override
    public void finishVote(Long reviewerId, Long reportTaskId) {
        System.out.println("运行环境: "+env);
        ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
        reviewerTaskStatus.setReviewerId(reviewerId);
        reviewerTaskStatus.setReportTaskId(reportTaskId);
        reviewerTaskStatus.setStatus(ReviewerTaskStatus.FINISHED);
        taskStatusDAO.update(reviewerTaskStatus);
    }
}


















