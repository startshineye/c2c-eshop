package com.yxm.c2c.social.govern.report.service.impl;
import com.yxm.c2c.social.govern.report.dao.ReportTaskDAO;
import com.yxm.c2c.social.govern.report.domain.ReportTask;
import com.yxm.c2c.social.govern.report.service.ReportTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportTaskServiceImpl implements ReportTaskService {

    @Autowired
    private ReportTaskDAO reportTaskDAO;

    @Override
    public void save(ReportTask task) {
        reportTaskDAO.save(task);
    }
}
