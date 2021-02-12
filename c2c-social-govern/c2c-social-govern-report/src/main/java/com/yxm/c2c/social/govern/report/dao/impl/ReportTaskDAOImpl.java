package com.yxm.c2c.social.govern.report.dao.impl;

import com.yxm.c2c.social.govern.report.dao.ReportTaskDAO;
import com.yxm.c2c.social.govern.report.domain.ReportTask;
import com.yxm.c2c.social.govern.report.mapper.ReportTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportTaskDAOImpl implements ReportTaskDAO {

    @Autowired
    private ReportTaskMapper mapper;

    @Override
    public void save(ReportTask task) {
        mapper.insert(task);
    }
}
