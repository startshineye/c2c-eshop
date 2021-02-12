package com.yxm.c2c.social.govern.report.service;

import com.yxm.c2c.social.govern.report.domain.ReportTask;

public interface ReportTaskService {
    /**
     * 增加举报任务
     * @param task 举报任务
     */
    void save(ReportTask task);

    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    ReportTask getById(Long id);
}
