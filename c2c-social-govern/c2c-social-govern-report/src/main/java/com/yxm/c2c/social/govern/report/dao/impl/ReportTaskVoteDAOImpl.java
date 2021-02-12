package com.yxm.c2c.social.govern.report.dao.impl;
import com.yxm.c2c.social.govern.report.dao.ReportTaskVoteDAO;
import com.yxm.c2c.social.govern.report.domain.ReportTaskVote;
import com.yxm.c2c.social.govern.report.mapper.ReportTaskVoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 举报任务投票DAO组件
 */
@Repository
public class ReportTaskVoteDAOImpl implements ReportTaskVoteDAO {
    /**
     * 举报任务投票Mapper组件
     */
    @Autowired
    private ReportTaskVoteMapper reportTaskVoteMapper;
    /**
     * 增加举报任务投票
     * @param reportTaskVote 举报任务投票
     */
    public void save(ReportTaskVote reportTaskVote) {
        reportTaskVoteMapper.insert(reportTaskVote);
    }

    @Override
    public void update(ReportTaskVote reportTaskVote) {
        reportTaskVoteMapper.update(reportTaskVote);
    }

    @Override
    public List<ReportTaskVote> getByReportTaskId(Long reportTaskId) {
        return reportTaskVoteMapper.selectByReportTaskId(reportTaskId);
    }
}
