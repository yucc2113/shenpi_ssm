package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.UflowWork;

public interface UFlowWorkService {
   public int insert(UflowWork bean);
   public UflowWork searchById(Integer id); 
	public List<UflowWork> searchUflowWorkByBean(UflowWork bean);
	
	public int deleteByZhuId(Integer zhuId);
	
	public int updateById(UflowWork bean);
   
}
