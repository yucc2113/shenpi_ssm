package com.ccgj.database.mapper;

import com.ccgj.database.beans.DefineNeirong;
import com.ccgj.database.beans.DefineNeirongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefineNeirongMapper {
    int countByExample(DefineNeirongExample example);

    int deleteByExample(DefineNeirongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DefineNeirong record);

    int insertSelective(DefineNeirong record);

    List<DefineNeirong> selectByExample(DefineNeirongExample example);

    DefineNeirong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DefineNeirong record, @Param("example") DefineNeirongExample example);

    int updateByExample(@Param("record") DefineNeirong record, @Param("example") DefineNeirongExample example);

    int updateByPrimaryKeySelective(DefineNeirong record);

    int updateByPrimaryKey(DefineNeirong record);
}