package com.yxm.c2c.social.govern.report.mapper;

import com.yxm.c2c.social.govern.report.domain.ReportTask;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportTaskMapper {
    @Insert("INSERT INTO report_task(type,report_user_id,report_content,target_id)" +
            " VALUES(#{type},#{reportUserId},#{reportContent},#{targetId})")
    void insert(ReportTask task);
}
