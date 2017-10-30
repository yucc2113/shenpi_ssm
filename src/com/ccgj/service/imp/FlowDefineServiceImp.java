package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.FlowDefine;
import com.ccgj.database.beans.FlowDefineExample;
import com.ccgj.database.mapper.FlowDefineMapper;
import com.ccgj.service.inter.FlowDefineService;
import com.github.pagehelper.PageHelper;

public class FlowDefineServiceImp implements FlowDefineService{
   @Autowired
   private FlowDefineMapper flowDefineMapper;
	
	@Override
	public CommonPage<FlowDefine> searchByNameAndStateWithPage(String name, Integer state,Integer pageNum) {
		FlowDefineExample bean=new FlowDefineExample();
		FlowDefineExample.Criteria criteria= bean.createCriteria();
		System.out.println("hi1");
		if(name!=null&&name.length()>0){
			criteria.andFlowNameLike("%"+name+"%");
		}if(state!=null&&state>0){
			criteria.andIsEnabledEqualTo(state);
		}
		System.out.println("hi");
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<FlowDefine> list = flowDefineMapper.selectByExample(bean);
		
		return (CommonPage<FlowDefine>) BeanUtil.toPagedResult(list);
	}

	@Override
	public List<FlowDefine> searchByIsEnabled(Integer idEnabled) {
		FlowDefineExample bean=new FlowDefineExample();
		bean.createCriteria().andIsEnabledEqualTo(idEnabled);
		return flowDefineMapper.selectByExample(bean);
	}

	@Override
	public int insert(FlowDefine bean) {
		return flowDefineMapper.insert(bean);
	}

	@Override
	public FlowDefine searchById(Integer id) {
		return flowDefineMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateById(Integer id, FlowDefine bean) {
		bean.setId(id);
		return flowDefineMapper.updateByPrimaryKeySelective(bean);
	}

}
