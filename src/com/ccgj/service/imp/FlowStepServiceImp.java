package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.FlowStep;
import com.ccgj.database.beans.FlowStepExample;
import com.ccgj.database.mapper.FlowStepMapper;
import com.ccgj.service.inter.FlowStepService;

public class FlowStepServiceImp implements FlowStepService{

	@Autowired
	private FlowStepMapper flowStepMapper;
	
	@Override
	public List<FlowStep> searchByZhuIdAndName(Integer zhuId, String stepName) {
		FlowStepExample bean=new FlowStepExample();
		FlowStepExample.Criteria criteria=bean.createCriteria();
		if(zhuId!=null&&zhuId>0){
			criteria.andFlowIdEqualTo(zhuId);
		}
		if(stepName!=null&&stepName.length()>0){
			criteria.andStepNameLike("%"+stepName+"%");
		}
		criteria.andFlagEqualTo(1);
		return flowStepMapper.selectByExample(bean);
	}

	@Override
	public FlowStep searchById(Integer id) {
	
		return flowStepMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(FlowStep flowStep) {
		
		return flowStepMapper.insert(flowStep);
	}

	@Override
	public int update(Integer id, FlowStep flowStep) {
		flowStep.setId(id);
		return flowStepMapper.updateByPrimaryKeySelective(flowStep);
	}

	@Override
	public List<FlowStep> searchByZhuIdAndLastId(Integer zhuId, Integer lastId) {
		FlowStepExample bean=new FlowStepExample();
		FlowStepExample.Criteria criteria=bean.createCriteria();
		if(zhuId!=null&&zhuId>0){
			criteria.andFlowIdEqualTo(zhuId);
		}
		if(lastId!=null){
			criteria.andLastIdEqualTo(lastId);
		}
		criteria.andFlagEqualTo(1);
		return flowStepMapper.selectByExample(bean);
	}

}
