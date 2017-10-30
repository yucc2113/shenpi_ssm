package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.Official;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.database.custom.beans.OfficialCustom;

public interface OfficialCustomMapper {
	 public List<OfficialCustom>  selectByNameAndDate(@Param("name") String name,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("state") Integer state);
	 public List<OfficialCustom>  selectByNameAndDateAndUserId(@Param("userId") Integer userId,@Param("name") String name,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("state") Integer state);

}
