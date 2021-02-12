package com.yxm.c2c.social.govern.report.dao;
import com.yxm.c2c.social.govern.report.domain.ReportTask;
public interface ReportTaskDAO {
    /**
     * 增加一个举报任务
     * @param task 举报任务
     */
    void save(ReportTask task);
    /**
     * 根据id查询举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    ReportTask getById(Long id);
    /**
     * 更新举报任务
     * @param reportTask
     */
    void update(ReportTask reportTask);
}
