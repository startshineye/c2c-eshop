package com.yxm.c2c.social.govern.report.dao;

import com.yxm.c2c.social.govern.report.domain.ReportTaskVote;

/**
 * 举报任务投票DAO接口
 */
public interface ReportTaskVoteDAO {
    /**
     * 增加举报任务投票
     * @param reportTaskVote 举报任务投票
     */
    void save(ReportTaskVote reportTaskVote);
}
