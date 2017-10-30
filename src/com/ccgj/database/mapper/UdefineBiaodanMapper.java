package com.ccgj.database.mapper;

import com.ccgj.database.beans.UdefineBiaodan;
import com.ccgj.database.beans.UdefineBiaodanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdefineBiaodanMapper {
    int countByExample(UdefineBiaodanExample example);

    int deleteByExample(UdefineBiaodanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UdefineBiaodan record);

    int insertSelective(UdefineBiaodan record);

    List<UdefineBiaodan> selectByExampleWithBLOBs(UdefineBiaodanExample example);

    List<UdefineBiaodan> selectByExample(UdefineBiaodanExample example);

    UdefineBiaodan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UdefineBiaodan record, @Param("example") UdefineBiaodanExample example);

    int updateByExampleWithBLOBs(@Param("record") UdefineBiaodan record, @Param("example") UdefineBiaodanExample example);

    int updateByExample(@Param("record") UdefineBiaodan record, @Param("example") UdefineBiaodanExample example);

    int updateByPrimaryKeySelective(UdefineBiaodan record);

    int updateByPrimaryKeyWithBLOBs(UdefineBiaodan record);

    int updateByPrimaryKey(UdefineBiaodan record);
}