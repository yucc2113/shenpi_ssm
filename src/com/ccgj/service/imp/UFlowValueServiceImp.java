package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.UflowValue;
import com.ccgj.database.beans.UflowValueExample;
import com.ccgj.database.mapper.UflowValueMapper;
import com.ccgj.service.inter.UFlowValueService;

public class UFlowValueServiceImp implements UFlowValueService{

	@Autowired
	private UflowValueMapper uflowValueMapper;
	@Override
	public int insert(UflowValue bean) {
	
		return uflowValueMapper.insert(bean);
	}
	@Override
	public List<UflowValue> searchByBiaodanId(Integer biaodanId) {
		UflowValueExample example=new UflowValueExample();
		example.createCriteria().andBaiodanidEqualTo(biaodanId);
		return uflowValueMapper.selectByExample(example);
	}
	@Override
	public int deleteByZhuId(Integer zhuId) {
		UflowValueExample example=new UflowValueExample();
		example.createCriteria().andBaiodanidEqualTo(zhuId);
		return uflowValueMapper.deleteByExample(example);
	}
	@Override
	public List<UflowValue> searchByBean(UflowValue bean) {
		UflowValueExample example=new UflowValueExample();
		UflowValueExample.Criteria criteria=example.createCriteria();
		if(bean.getId()!=null&&bean.getId()>0){
			criteria.andIdEqualTo(bean.getId());
		}if(bean.getBaiodanid()!=null&&bean.getBaiodanid()>0){
			criteria.andBaiodanidEqualTo(bean.getBaiodanid());
		}if(bean.getDataelementtype()!=null&&bean.getDataelementtype().length()>0){
			criteria.andDataelementtypeEqualTo(bean.getDataelementtype());
		}if(bean.getDataelement()!=null&&bean.getDataelement().length()>0){
			criteria.andDataelementEqualTo(bean.getDataelement());
		}
		return uflowValueMapper.selectByExample(example);
	}

}
