package com.yxm.c2c.social.govern.reviewer.mapper;

import com.yxm.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewerTaskStatusMapper {
    /**
     * 保存
     * @param taskStatus 任务状态
     */
    @Insert("INSERT INTO reviewer_task_status(reviewer_id,report_task_id,status) " +
            "VALUES(#{reviewerId},#{reportTaskId},#{status})")
    void insert(ReviewerTaskStatus taskStatus);
}
