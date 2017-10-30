package com.ccgj.database.mapper;

import com.ccgj.database.beans.UliuchengBiaodan;
import com.ccgj.database.beans.UliuchengBiaodanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UliuchengBiaodanMapper {
    int countByExample(UliuchengBiaodanExample example);

    int deleteByExample(UliuchengBiaodanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UliuchengBiaodan record);

    int insertSelective(UliuchengBiaodan record);

    List<UliuchengBiaodan> selectByExampleWithBLOBs(UliuchengBiaodanExample example);

    List<UliuchengBiaodan> selectByExample(UliuchengBiaodanExample example);

    UliuchengBiaodan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UliuchengBiaodan record, @Param("example") UliuchengBiaodanExample example);

    int updateByExampleWithBLOBs(@Param("record") UliuchengBiaodan record, @Param("example") UliuchengBiaodanExample example);

    int updateByExample(@Param("record") UliuchengBiaodan record, @Param("example") UliuchengBiaodanExample example);

    int updateByPrimaryKeySelective(UliuchengBiaodan record);

    int updateByPrimaryKeyWithBLOBs(UliuchengBiaodan record);

    int updateByPrimaryKey(UliuchengBiaodan record);
}