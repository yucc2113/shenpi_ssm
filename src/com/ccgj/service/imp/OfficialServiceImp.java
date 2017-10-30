package com.ccgj.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.Official;
import com.ccgj.database.beans.OfficialExample;
import com.ccgj.database.beans.OfficialUser;
import com.ccgj.database.custom.beans.OfficialCustom;
import com.ccgj.database.custom.mapper.OfficialCustomMapper;
import com.ccgj.database.mapper.OfficialMapper;
import com.ccgj.service.inter.OfficialService;
import com.github.pagehelper.PageHelper;

public class OfficialServiceImp implements OfficialService{

	@Autowired
	private OfficialMapper officialMapper;
	@Autowired
	private OfficialCustomMapper officialCustomMapper;
	
	@Override
	public List<Official> searchByWenhao(String wenhao) {
		OfficialExample bean=new OfficialExample();
		bean.createCriteria().andWenhaoLike(wenhao+"%");
		
		return officialMapper.selectByExample(bean);
	}
	@Override
	public int insertOfficial(Official official) {
		
		return officialMapper.insert(official);
	}
	@Override
	public List<Official> searchAllList() {
		return officialMapper.selectByExample(null);
	}
	@Override
	public  CommonPage<OfficialCustom> searchListByNameAndDateWithPage(String name, Date startDate,
			Date endDate,Integer pageNum,Integer state) {
		if(name!=null&&name.length()>0)name="%"+name+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<OfficialCustom> list = officialCustomMapper.selectByNameAndDate(name,
				startDate, endDate,state);
		
		return (CommonPage<OfficialCustom>) BeanUtil.toPagedResult(list);
	}
	@Override
	public Official searchById(Integer id) {
		
		return officialMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateOfficial(Official official) {
		// TODO Auto-generated method stub
		return officialMapper.updateByPrimaryKeySelective(official);
	}
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return officialMapper.deleteByPrimaryKey(id);
	}
	@Override
	public CommonPage<OfficialCustom> searchListByNameAndDateAndUserIdWithPage(
			Integer userId, String name, Date startDate, Date endDate,
			Integer pageNum, Integer state) {
		if(name!=null&&name.length()>0)name="%"+name+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<OfficialCustom> list = officialCustomMapper.selectByNameAndDateAndUserId(userId,name,
				startDate, endDate,state);
		
		return (CommonPage<OfficialCustom>) BeanUtil.toPagedResult(list);
	}

}
