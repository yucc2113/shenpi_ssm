package com.ccgj.database.mapper;

import com.ccgj.database.beans.Shenpi;
import com.ccgj.database.beans.ShenpiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShenpiMapper {
    int countByExample(ShenpiExample example);

    int deleteByExample(ShenpiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shenpi record);

    int insertSelective(Shenpi record);

    List<Shenpi> selectByExample(ShenpiExample example);

    Shenpi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shenpi record, @Param("example") ShenpiExample example);

    int updateByExample(@Param("record") Shenpi record, @Param("example") ShenpiExample example);

    int updateByPrimaryKeySelective(Shenpi record);

    int updateByPrimaryKey(Shenpi record);
}