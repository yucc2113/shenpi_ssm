package com.ccgj.database.mapper;

import com.ccgj.database.beans.FlowStep;
import com.ccgj.database.beans.FlowStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowStepMapper {
    int countByExample(FlowStepExample example);

    int deleteByExample(FlowStepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowStep record);

    int insertSelective(FlowStep record);

    List<FlowStep> selectByExample(FlowStepExample example);

    FlowStep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowStep record, @Param("example") FlowStepExample example);

    int updateByExample(@Param("record") FlowStep record, @Param("example") FlowStepExample example);

    int updateByPrimaryKeySelective(FlowStep record);

    int updateByPrimaryKey(FlowStep record);
}