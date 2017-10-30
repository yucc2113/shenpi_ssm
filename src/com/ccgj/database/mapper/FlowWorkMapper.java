package com.ccgj.database.mapper;

import com.ccgj.database.beans.FlowWork;
import com.ccgj.database.beans.FlowWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowWorkMapper {
    int countByExample(FlowWorkExample example);

    int deleteByExample(FlowWorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowWork record);

    int insertSelective(FlowWork record);

    List<FlowWork> selectByExample(FlowWorkExample example);

    FlowWork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowWork record, @Param("example") FlowWorkExample example);

    int updateByExample(@Param("record") FlowWork record, @Param("example") FlowWorkExample example);

    int updateByPrimaryKeySelective(FlowWork record);

    int updateByPrimaryKey(FlowWork record);
}