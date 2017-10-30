package com.ccgj.database.mapper;

import com.ccgj.database.beans.UserModule;
import com.ccgj.database.beans.UserModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserModuleMapper {
    int countByExample(UserModuleExample example);

    int deleteByExample(UserModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserModule record);

    int insertSelective(UserModule record);

    List<UserModule> selectByExample(UserModuleExample example);

    UserModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserModule record, @Param("example") UserModuleExample example);

    int updateByExample(@Param("record") UserModule record, @Param("example") UserModuleExample example);

    int updateByPrimaryKeySelective(UserModule record);

    int updateByPrimaryKey(UserModule record);
}