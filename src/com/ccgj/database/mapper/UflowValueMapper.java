package com.ccgj.database.mapper;

import com.ccgj.database.beans.UflowValue;
import com.ccgj.database.beans.UflowValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UflowValueMapper {
    int countByExample(UflowValueExample example);

    int deleteByExample(UflowValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UflowValue record);

    int insertSelective(UflowValue record);

    List<UflowValue> selectByExample(UflowValueExample example);

    UflowValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UflowValue record, @Param("example") UflowValueExample example);

    int updateByExample(@Param("record") UflowValue record, @Param("example") UflowValueExample example);

    int updateByPrimaryKeySelective(UflowValue record);

    int updateByPrimaryKey(UflowValue record);
}