package com.ccgj.database.mapper;

import com.ccgj.database.beans.FlowDefine;
import com.ccgj.database.beans.FlowDefineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowDefineMapper {
    int countByExample(FlowDefineExample example);

    int deleteByExample(FlowDefineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowDefine record);

    int insertSelective(FlowDefine record);

    List<FlowDefine> selectByExample(FlowDefineExample example);

    FlowDefine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowDefine record, @Param("example") FlowDefineExample example);

    int updateByExample(@Param("record") FlowDefine record, @Param("example") FlowDefineExample example);

    int updateByPrimaryKeySelective(FlowDefine record);

    int updateByPrimaryKey(FlowDefine record);
}