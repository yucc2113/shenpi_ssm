package com.ccgj.database.mapper;

import com.ccgj.database.beans.UdefineNeirong;
import com.ccgj.database.beans.UdefineNeirongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdefineNeirongMapper {
    int countByExample(UdefineNeirongExample example);

    int deleteByExample(UdefineNeirongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UdefineNeirong record);

    int insertSelective(UdefineNeirong record);

    List<UdefineNeirong> selectByExample(UdefineNeirongExample example);

    UdefineNeirong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UdefineNeirong record, @Param("example") UdefineNeirongExample example);

    int updateByExample(@Param("record") UdefineNeirong record, @Param("example") UdefineNeirongExample example);

    int updateByPrimaryKeySelective(UdefineNeirong record);

    int updateByPrimaryKey(UdefineNeirong record);
}