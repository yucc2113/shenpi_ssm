package com.ccgj.database.mapper;

import com.ccgj.database.beans.LiuchengDetail;
import com.ccgj.database.beans.LiuchengDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiuchengDetailMapper {
    int countByExample(LiuchengDetailExample example);

    int deleteByExample(LiuchengDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LiuchengDetail record);

    int insertSelective(LiuchengDetail record);

    List<LiuchengDetail> selectByExample(LiuchengDetailExample example);

    LiuchengDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LiuchengDetail record, @Param("example") LiuchengDetailExample example);

    int updateByExample(@Param("record") LiuchengDetail record, @Param("example") LiuchengDetailExample example);

    int updateByPrimaryKeySelective(LiuchengDetail record);

    int updateByPrimaryKey(LiuchengDetail record);
}