package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccgj.database.beans.News;

public interface NewsCustomMapper {
	 public List<News>  selectByTitleAndDate(@Param("title") String title,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("state") Integer state);
	
}
