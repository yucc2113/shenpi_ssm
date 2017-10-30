package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.FlowStep;

public interface FlowStepService {

	//根据FlowId和flowStepName查询
	public List<FlowStep> searchByZhuIdAndName(Integer zhuId,String stepName);
	
	public List<FlowStep> searchByZhuIdAndLastId(Integer zhuId,Integer  lastId);
	
	//根据ID查询步骤信息
	public FlowStep searchById(Integer id);
	
	//添加信息
	public int insert(FlowStep flowStep);
	
	//修改信息
	public int update(Integer id,FlowStep flowStep);
}
