package com.ccgj.database.mapper;

import com.ccgj.database.beans.MeetUser;
import com.ccgj.database.beans.MeetUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeetUserMapper {
    int countByExample(MeetUserExample example);

    int deleteByExample(MeetUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MeetUser record);

    int insertSelective(MeetUser record);

    List<MeetUser> selectByExample(MeetUserExample example);

    MeetUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MeetUser record, @Param("example") MeetUserExample example);

    int updateByExample(@Param("record") MeetUser record, @Param("example") MeetUserExample example);

    int updateByPrimaryKeySelective(MeetUser record);

    int updateByPrimaryKey(MeetUser record);
}