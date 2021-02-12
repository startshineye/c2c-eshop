package com.yxm.c2c.social.govern.reviewer.dao.impl;

import com.yxm.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDAO;
import com.yxm.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import com.yxm.c2c.social.govern.reviewer.mapper.ReviewerTaskStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewerTaskStatusDAOImpl implements ReviewerTaskStatusDAO {

    @Autowired
    private ReviewerTaskStatusMapper taskStatusMapper;

    @Override
    public void save(ReviewerTaskStatus taskStatus) {
        taskStatusMapper.insert(taskStatus);
    }
}
