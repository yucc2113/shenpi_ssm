package com.ccgj.database.mapper;

import com.ccgj.database.beans.Official;
import com.ccgj.database.beans.OfficialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficialMapper {
    int countByExample(OfficialExample example);

    int deleteByExample(OfficialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Official record);

    int insertSelective(Official record);

    List<Official> selectByExample(OfficialExample example);

    Official selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Official record, @Param("example") OfficialExample example);

    int updateByExample(@Param("record") Official record, @Param("example") OfficialExample example);

    int updateByPrimaryKeySelective(Official record);

    int updateByPrimaryKey(Official record);
}