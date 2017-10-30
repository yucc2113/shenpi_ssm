package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.OfficialUser;

public interface OfficialUserService {
 
	public int  insert(OfficialUser officialUser);
	
	//根据zhuId删除数据
	
	public int deleteByZhuId(Integer zhuId);
	
	public List<OfficialUser> searchListByZhuId(Integer zhuId);
}
