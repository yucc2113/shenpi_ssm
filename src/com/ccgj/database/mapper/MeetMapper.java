package com.ccgj.database.mapper;

import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.MeetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeetMapper {
    int countByExample(MeetExample example);

    int deleteByExample(MeetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Meet record);

    int insertSelective(Meet record);

    List<Meet> selectByExample(MeetExample example);

    Meet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Meet record, @Param("example") MeetExample example);

    int updateByExample(@Param("record") Meet record, @Param("example") MeetExample example);

    int updateByPrimaryKeySelective(Meet record);

    int updateByPrimaryKey(Meet record);
}