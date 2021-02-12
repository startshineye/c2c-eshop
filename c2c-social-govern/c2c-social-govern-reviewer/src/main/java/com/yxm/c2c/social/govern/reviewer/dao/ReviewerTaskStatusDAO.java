package com.yxm.c2c.social.govern.reviewer.dao;
import com.yxm.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;

public interface ReviewerTaskStatusDAO {
    /**
     * 保存
     * @param taskStatus 举报状态
     */
    void save(ReviewerTaskStatus taskStatus);
    /**
     * 更新评审员处理举报任务的状态
     * @param reviewerTaskStatus 评审员处理举报任务的状态
     */
    void update(ReviewerTaskStatus reviewerTaskStatus);
}
