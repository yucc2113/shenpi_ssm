package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccgj.database.beans.Meet;

public interface MeetCustomMapper {
	 public List<Meet>  selectByNameAndDate(@Param("name") String name,@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	 
	 public List<Meet>  selectByNameAndDateAndUserId(@Param("userId") Integer userId,@Param("name") String name,@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
