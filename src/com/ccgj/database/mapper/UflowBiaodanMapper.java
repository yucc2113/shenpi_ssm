package com.ccgj.database.mapper;

import com.ccgj.database.beans.UflowBiaodan;
import com.ccgj.database.beans.UflowBiaodanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UflowBiaodanMapper {
    int countByExample(UflowBiaodanExample example);

    int deleteByExample(UflowBiaodanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UflowBiaodan record);

    int insertSelective(UflowBiaodan record);

    List<UflowBiaodan> selectByExampleWithBLOBs(UflowBiaodanExample example);

    List<UflowBiaodan> selectByExample(UflowBiaodanExample example);

    UflowBiaodan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UflowBiaodan record, @Param("example") UflowBiaodanExample example);

    int updateByExampleWithBLOBs(@Param("record") UflowBiaodan record, @Param("example") UflowBiaodanExample example);

    int updateByExample(@Param("record") UflowBiaodan record, @Param("example") UflowBiaodanExample example);

    int updateByPrimaryKeySelective(UflowBiaodan record);

    int updateByPrimaryKeyWithBLOBs(UflowBiaodan record);

    int updateByPrimaryKey(UflowBiaodan record);
}