package com.ccgj.service.inter;

import java.util.Date;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.UflowBiaodan;
import com.ccgj.database.beans.UflowWork;
import com.ccgj.database.beans.Users;

public interface UFlowBiaodanService {

	public int insert(UflowBiaodan bean);
	
	public CommonPage<UflowBiaodan> searchByNameAndDateAndUserWithPage(String name,Date startDate ,Date endDate,Users user,Integer pageNum);
	
	public List<UflowBiaodan> searchByuserId(Integer userId);
	
	public UflowBiaodan searchById(Integer id);
	
	public CommonPage<UflowBiaodan> searchByUserWithPage(Users user,Integer pageNum);
	
	public List<UflowBiaodan> searchByUser(Users user);
  
	public List<UflowWork> searchUflowWorkByFlowIdAndWorkIdAndState(Integer flowId,Integer workId);
	
	public int deleteById(Integer id);
	
	public int updateById(UflowBiaodan bean);


}
