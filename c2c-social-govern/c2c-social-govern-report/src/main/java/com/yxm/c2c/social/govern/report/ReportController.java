package com.yxm.c2c.social.govern.report;
import com.yxm.c2c.social.govern.reviewer.api.ReviewerService;
import com.yxm.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Reference(version = "1.0.0",
            interfaceClass = ReviewerService.class,
            cluster = "failfast")
    private ReviewerService reviewerService;

    @Reference(version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast")
    private RewardService rewardService;

}
