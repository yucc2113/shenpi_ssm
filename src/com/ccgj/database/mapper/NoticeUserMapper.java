package com.ccgj.database.mapper;

import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.beans.NoticeUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeUserMapper {
    int countByExample(NoticeUserExample example);

    int deleteByExample(NoticeUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeUser record);

    int insertSelective(NoticeUser record);

    List<NoticeUser> selectByExample(NoticeUserExample example);

    NoticeUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeUser record, @Param("example") NoticeUserExample example);

    int updateByExample(@Param("record") NoticeUser record, @Param("example") NoticeUserExample example);

    int updateByPrimaryKeySelective(NoticeUser record);

    int updateByPrimaryKey(NoticeUser record);
}