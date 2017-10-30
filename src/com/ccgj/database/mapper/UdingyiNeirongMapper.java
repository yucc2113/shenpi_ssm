package com.ccgj.database.mapper;

import com.ccgj.database.beans.UdingyiNeirong;
import com.ccgj.database.beans.UdingyiNeirongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdingyiNeirongMapper {
    int countByExample(UdingyiNeirongExample example);

    int deleteByExample(UdingyiNeirongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UdingyiNeirong record);

    int insertSelective(UdingyiNeirong record);

    List<UdingyiNeirong> selectByExample(UdingyiNeirongExample example);

    UdingyiNeirong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UdingyiNeirong record, @Param("example") UdingyiNeirongExample example);

    int updateByExample(@Param("record") UdingyiNeirong record, @Param("example") UdingyiNeirongExample example);

    int updateByPrimaryKeySelective(UdingyiNeirong record);

    int updateByPrimaryKey(UdingyiNeirong record);
}