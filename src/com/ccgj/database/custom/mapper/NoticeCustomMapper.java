package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ccgj.database.custom.beans.NoticeCustom;


public interface NoticeCustomMapper {
	 public List<NoticeCustom>  selectByTitleAndDate(@Param("title") String title,@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	 
	 public List<NoticeCustom> selectByTitleAndDateAndUserId(@Param("userId") Integer userId, @Param("title") String title,@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
