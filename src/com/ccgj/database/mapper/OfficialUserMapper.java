package com.ccgj.database.mapper;

import com.ccgj.database.beans.OfficialUser;
import com.ccgj.database.beans.OfficialUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficialUserMapper {
    int countByExample(OfficialUserExample example);

    int deleteByExample(OfficialUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OfficialUser record);

    int insertSelective(OfficialUser record);

    List<OfficialUser> selectByExample(OfficialUserExample example);

    OfficialUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OfficialUser record, @Param("example") OfficialUserExample example);

    int updateByExample(@Param("record") OfficialUser record, @Param("example") OfficialUserExample example);

    int updateByPrimaryKeySelective(OfficialUser record);

    int updateByPrimaryKey(OfficialUser record);
}