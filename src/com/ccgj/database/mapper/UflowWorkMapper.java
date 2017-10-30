package com.ccgj.database.mapper;

import com.ccgj.database.beans.UflowWork;
import com.ccgj.database.beans.UflowWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UflowWorkMapper {
    int countByExample(UflowWorkExample example);

    int deleteByExample(UflowWorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UflowWork record);

    int insertSelective(UflowWork record);

    List<UflowWork> selectByExample(UflowWorkExample example);

    UflowWork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UflowWork record, @Param("example") UflowWorkExample example);

    int updateByExample(@Param("record") UflowWork record, @Param("example") UflowWorkExample example);

    int updateByPrimaryKeySelective(UflowWork record);

    int updateByPrimaryKey(UflowWork record);
}