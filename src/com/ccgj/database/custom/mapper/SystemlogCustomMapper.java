package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ccgj.database.beans.Systemlog;

public interface SystemlogCustomMapper {
    public List<Systemlog>  selectByNameAndDate(@Param("name") String name,@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
