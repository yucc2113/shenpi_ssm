package com.ccgj.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.database.custom.mapper.SystemlogCustomMapper;
import com.ccgj.database.mapper.SystemlogMapper;
import com.ccgj.service.inter.SystemlogService;
import com.github.pagehelper.PageHelper;

public class SystemlogServiceImp implements SystemlogService{
    @Autowired
    private SystemlogMapper systemlogMapper;
    @Autowired
    private SystemlogCustomMapper systemlogCustomMapper;
	@Override
	public List<Systemlog> searchSystemlogList() {
		return systemlogMapper.selectByExample(null);
	}

	@Override
	public CommonPage<Systemlog> searchSystemlogListByPage(Integer pageNum) {
		pageNum = pageNum == null?1:pageNum;  
	    int pageSize =10;  
	    PageHelper.startPage(pageNum,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
	    List<Systemlog> list=systemlogMapper.selectByExample(null);
	   
	    return (CommonPage<Systemlog>) BeanUtil.toPagedResult(list); 
	}

	@Override
	public CommonPage<Systemlog> searchSystemlogListByNameAndDateByPage(String name,
			Date startDate, Date endDate,Integer pageNum) {
		 if(endDate==null)
			endDate=new Date();
		 pageNum = pageNum == null?1:pageNum;  
		 int pageSize =10;  
		 PageHelper.startPage(pageNum,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		 List<Systemlog> list=systemlogCustomMapper.selectByNameAndDate(name, startDate, endDate);
		 return (CommonPage<Systemlog>) BeanUtil.toPagedResult(list); 
	}

	@Override
	public int insertSystemlog(String username,Integer userId,String content) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Systemlog bean=new Systemlog();
		bean.setCreatusername(username);
		bean.setCreatuserid(userId);
		bean.setLogcontent(content);
		try {
			bean.setCreatdate(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return systemlogMapper.insert(bean);
	}

}
