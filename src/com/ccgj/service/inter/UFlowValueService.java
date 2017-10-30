package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.UflowValue;

public interface UFlowValueService {

	public int insert(UflowValue bean);
	public List<UflowValue> searchByBiaodanId(Integer biaodanId);
	
	public int deleteByZhuId(Integer zhuId);
	public List<UflowValue> searchByBean(UflowValue bean);
}
