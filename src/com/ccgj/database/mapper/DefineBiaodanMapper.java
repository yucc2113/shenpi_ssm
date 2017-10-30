package com.ccgj.database.mapper;

import com.ccgj.database.beans.DefineBiaodan;
import com.ccgj.database.beans.DefineBiaodanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefineBiaodanMapper {
    int countByExample(DefineBiaodanExample example);

    int deleteByExample(DefineBiaodanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DefineBiaodan record);

    int insertSelective(DefineBiaodan record);

    List<DefineBiaodan> selectByExample(DefineBiaodanExample example);

    DefineBiaodan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DefineBiaodan record, @Param("example") DefineBiaodanExample example);

    int updateByExample(@Param("record") DefineBiaodan record, @Param("example") DefineBiaodanExample example);

    int updateByPrimaryKeySelective(DefineBiaodan record);

    int updateByPrimaryKey(DefineBiaodan record);
}