package com.ccgj.database.mapper;

import com.ccgj.database.beans.UliuchengValue;
import com.ccgj.database.beans.UliuchengValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UliuchengValueMapper {
    int countByExample(UliuchengValueExample example);

    int deleteByExample(UliuchengValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UliuchengValue record);

    int insertSelective(UliuchengValue record);

    List<UliuchengValue> selectByExample(UliuchengValueExample example);

    UliuchengValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UliuchengValue record, @Param("example") UliuchengValueExample example);

    int updateByExample(@Param("record") UliuchengValue record, @Param("example") UliuchengValueExample example);

    int updateByPrimaryKeySelective(UliuchengValue record);

    int updateByPrimaryKey(UliuchengValue record);
}