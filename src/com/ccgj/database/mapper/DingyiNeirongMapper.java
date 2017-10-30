package com.ccgj.database.mapper;

import com.ccgj.database.beans.DingyiNeirong;
import com.ccgj.database.beans.DingyiNeirongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DingyiNeirongMapper {
    int countByExample(DingyiNeirongExample example);

    int deleteByExample(DingyiNeirongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DingyiNeirong record);

    int insertSelective(DingyiNeirong record);

    List<DingyiNeirong> selectByExample(DingyiNeirongExample example);

    DingyiNeirong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DingyiNeirong record, @Param("example") DingyiNeirongExample example);

    int updateByExample(@Param("record") DingyiNeirong record, @Param("example") DingyiNeirongExample example);

    int updateByPrimaryKeySelective(DingyiNeirong record);

    int updateByPrimaryKey(DingyiNeirong record);
}