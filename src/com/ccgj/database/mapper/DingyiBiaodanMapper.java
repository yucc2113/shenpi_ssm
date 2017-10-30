package com.ccgj.database.mapper;

import com.ccgj.database.beans.DingyiBiaodan;
import com.ccgj.database.beans.DingyiBiaodanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DingyiBiaodanMapper {
    int countByExample(DingyiBiaodanExample example);

    int deleteByExample(DingyiBiaodanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DingyiBiaodan record);

    int insertSelective(DingyiBiaodan record);

    List<DingyiBiaodan> selectByExample(DingyiBiaodanExample example);

    DingyiBiaodan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DingyiBiaodan record, @Param("example") DingyiBiaodanExample example);

    int updateByExample(@Param("record") DingyiBiaodan record, @Param("example") DingyiBiaodanExample example);

    int updateByPrimaryKeySelective(DingyiBiaodan record);

    int updateByPrimaryKey(DingyiBiaodan record);
}