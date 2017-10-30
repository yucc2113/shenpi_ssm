package com.ccgj.database.mapper;

import com.ccgj.database.beans.UdingyiBiaodan;
import com.ccgj.database.beans.UdingyiBiaodanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdingyiBiaodanMapper {
    int countByExample(UdingyiBiaodanExample example);

    int deleteByExample(UdingyiBiaodanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UdingyiBiaodan record);

    int insertSelective(UdingyiBiaodan record);

    List<UdingyiBiaodan> selectByExampleWithBLOBs(UdingyiBiaodanExample example);

    List<UdingyiBiaodan> selectByExample(UdingyiBiaodanExample example);

    UdingyiBiaodan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UdingyiBiaodan record, @Param("example") UdingyiBiaodanExample example);

    int updateByExampleWithBLOBs(@Param("record") UdingyiBiaodan record, @Param("example") UdingyiBiaodanExample example);

    int updateByExample(@Param("record") UdingyiBiaodan record, @Param("example") UdingyiBiaodanExample example);

    int updateByPrimaryKeySelective(UdingyiBiaodan record);

    int updateByPrimaryKeyWithBLOBs(UdingyiBiaodan record);

    int updateByPrimaryKey(UdingyiBiaodan record);
}