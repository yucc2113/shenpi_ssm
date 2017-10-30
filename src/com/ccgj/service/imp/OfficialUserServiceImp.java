package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.OfficialUser;
import com.ccgj.database.beans.OfficialUserExample;
import com.ccgj.database.mapper.OfficialUserMapper;
import com.ccgj.service.inter.OfficialUserService;

public class OfficialUserServiceImp implements OfficialUserService{

	@Autowired
	private OfficialUserMapper officialUserMapper;
	@Override
	public int insert(OfficialUser officialUser) {
		// TODO Auto-generated method stub
		return officialUserMapper.insert(officialUser);
	}
	@Override
	public List<OfficialUser> searchListByZhuId(Integer zhuId) {
		OfficialUserExample bean=new OfficialUserExample();
		bean.createCriteria().andOfficialIdEqualTo(zhuId);
		return officialUserMapper.selectByExample(bean);
	}
	@Override
	public int deleteByZhuId(Integer zhuId) {
		OfficialUserExample bean=new OfficialUserExample();
		bean.createCriteria().andOfficialIdEqualTo(zhuId);
		return officialUserMapper.deleteByExample(bean);
	}

}
