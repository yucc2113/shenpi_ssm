package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccgj.database.beans.UdefineBiaodan;

public interface UdefineBiaodanCustomMapper {
   
	public List<UdefineBiaodan> selectByNameAndDate(@Param("name")String name,
			@Param("startDate")Date startDate,@Param("endDate")Date endDate,
			@Param("state")Integer state);
}
