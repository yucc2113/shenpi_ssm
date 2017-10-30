package com.ccgj.database.custom.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccgj.database.beans.UflowBiaodan;
import com.ccgj.database.beans.UflowWork;
import com.ccgj.database.beans.Users;

public interface UflowBiaodanCustomMapper {
    public List<UflowBiaodan> searchByUser(Users user);
    public List<UflowBiaodan> searchByNameAndDateAndUser(@Param("name")String name,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("user")Users user);
    public List<UflowWork> searchWorkByFlowIdAndWorkIdAndState(@Param("flowId")Integer flowId,@Param("workId")Integer workId,@Param("state")Integer state);
}
