package com.ccgj.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.database.beans.UflowBiaodan;
import com.ccgj.database.beans.UflowBiaodanExample;
import com.ccgj.database.beans.UflowWork;
import com.ccgj.database.beans.UflowWorkExample;
import com.ccgj.database.beans.Users;
import com.ccgj.database.custom.mapper.UflowBiaodanCustomMapper;
import com.ccgj.database.mapper.UflowBiaodanMapper;
import com.ccgj.service.inter.UFlowBiaodanService;
import com.github.pagehelper.PageHelper;

public class UFlowBiaodanServiceImp implements UFlowBiaodanService{
    @Autowired
    private UflowBiaodanMapper uflowBiaodanMapper;
    @Autowired
    private UflowBiaodanCustomMapper uflowBiaodanCustomMapper;
	@Override
	public int insert(UflowBiaodan bean) {
		return uflowBiaodanMapper.insert(bean);
	}
    /**
     * 任务列表显示页面
     * 显示该用户启动的流程
     */
	@Override
	public List<UflowBiaodan> searchByuserId(Integer userId) {
		UflowBiaodanExample bean=new UflowBiaodanExample();
		bean.createCriteria().andCreateuserEqualTo(userId);
		return uflowBiaodanMapper.selectByExample(bean);
	}
    /**
     * 查寻某人需要审批的流程
     */
	@Override
	public CommonPage<UflowBiaodan> searchByUserWithPage(Users user,Integer pageNum) {
		pageNum = pageNum == null?1:pageNum;  
	    int pageSize =3;  
	    PageHelper.startPage(pageNum,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<UflowBiaodan> list=new ArrayList<UflowBiaodan>();
	    list= uflowBiaodanCustomMapper.searchByUser(user);   
	    return (CommonPage<UflowBiaodan>) BeanUtil.toPagedResult(list); 
	}
	
	@Override
	public List<UflowBiaodan> searchByUser(Users user) {
		return uflowBiaodanCustomMapper.searchByUser(user);   
		 
	}
	@Override
	public CommonPage<UflowBiaodan> searchByNameAndDateAndUserWithPage(
			String name, Date startDate, Date endDate, Users user,Integer pageNum) {
		pageNum = pageNum == null?1:pageNum;
		name=name!=null?"%"+name+"%":name;
	    int pageSize =3;  
	    PageHelper.startPage(pageNum,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<UflowBiaodan> list=new ArrayList<UflowBiaodan>();
	    list= uflowBiaodanCustomMapper.searchByNameAndDateAndUser(name, startDate, endDate, user);   
	    return (CommonPage<UflowBiaodan>) BeanUtil.toPagedResult(list); 
		
	}
	@Override
	public UflowBiaodan searchById(Integer id) {
		
		return uflowBiaodanMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<UflowWork> searchUflowWorkByFlowIdAndWorkIdAndState(
			Integer flowId, Integer workId) {
		
		return uflowBiaodanCustomMapper.searchWorkByFlowIdAndWorkIdAndState(flowId, workId, 1);
	}
	@Override
	public int deleteById(Integer id) {
		
		return uflowBiaodanMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int updateById(UflowBiaodan bean) {
		
		return uflowBiaodanMapper.updateByPrimaryKeySelective(bean);
	}

	


}
