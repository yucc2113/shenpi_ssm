package com.ccgj.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.News;
import com.ccgj.database.custom.beans.MeetCustom;
import com.ccgj.database.custom.mapper.MeetCustomMapper;
import com.ccgj.database.mapper.MeetMapper;
import com.ccgj.database.mapper.MeetUserMapper;
import com.ccgj.service.inter.MeetService;
import com.github.pagehelper.PageHelper;

public class MeetServiceImp implements MeetService{
    @Autowired
    private MeetMapper meetMapper;
    @Autowired
    private MeetUserMapper meetUserMapper;
    @Autowired
    private MeetCustomMapper meetCustomMapper;
	@Override
	public CommonPage<Meet> searchMeetByNameAndDateWithPage(String name,
			Date startDate, Date endDate, Integer pageNum) {
		
		if(name!=null&&name.length()>0)name="%"+name+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<Meet> list = meetCustomMapper.selectByNameAndDate(name,
				startDate, endDate);
		
		return (CommonPage<Meet>) BeanUtil.toPagedResult(list);
	}
	@Override
	public int insertMeet(Meet meet) {
		
		return meetMapper.insert(meet);
	}
	@Override
	public int deleteMeetById(Integer id) {
		return meetMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Meet searchMeetById(Integer id) {
		return meetMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateMeetById(Integer id, Meet meet) {
		meet.setId(id);
		return meetMapper.updateByPrimaryKeySelective(meet);
	}
	@Override
	public CommonPage<Meet> searchMeetByNameAndDateAndUserIdWithPage(
			Integer userId, String name, Date startDate, Date endDate,
			Integer pageNum) {
		
		if(name!=null&&name.length()>0)name="%"+name+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<Meet> list = meetCustomMapper.selectByNameAndDateAndUserId(userId,name,
				startDate, endDate);
		
		return (CommonPage<Meet>) BeanUtil.toPagedResult(list);
	}
	


}
