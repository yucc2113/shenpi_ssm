package com.ccgj.database.mapper;

import com.ccgj.database.beans.Officialset;
import com.ccgj.database.beans.OfficialsetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficialsetMapper {
    int countByExample(OfficialsetExample example);

    int deleteByExample(OfficialsetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Officialset record);

    int insertSelective(Officialset record);

    List<Officialset> selectByExample(OfficialsetExample example);

    Officialset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Officialset record, @Param("example") OfficialsetExample example);

    int updateByExample(@Param("record") Officialset record, @Param("example") OfficialsetExample example);

    int updateByPrimaryKeySelective(Officialset record);

    int updateByPrimaryKey(Officialset record);
}