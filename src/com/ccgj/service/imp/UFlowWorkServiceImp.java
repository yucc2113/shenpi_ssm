package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.UflowWork;
import com.ccgj.database.beans.UflowWorkExample;
import com.ccgj.database.mapper.UflowWorkMapper;
import com.ccgj.service.inter.UFlowWorkService;

public class UFlowWorkServiceImp implements UFlowWorkService{
    @Autowired
    private UflowWorkMapper uflowWorkMapper;
	@Override
	public int insert(UflowWork bean) {
	
		return uflowWorkMapper.insert(bean);
	}
	@Override
	public List<UflowWork> searchUflowWorkByBean(UflowWork bean) {
		UflowWorkExample example=new UflowWorkExample();
		UflowWorkExample.Criteria criteria=example.createCriteria();
		if(bean.getId()!=null&&bean.getId()>0){
			criteria.andIdEqualTo(bean.getId());
		}if(bean.getWorkId()!=null&&bean.getWorkId()>0){
			criteria.andWorkIdEqualTo(bean.getWorkId());
		}if(bean.getDealPosition()!=null&&bean.getDealPosition()>0){
			criteria.andDealPositionEqualTo(bean.getDealPosition());
		}if(bean.getDealRole()!=null&&bean.getDealRole()>0){
			criteria.andDealRoleEqualTo(bean.getDealRole());
		}if(bean.getDealUser()!=null&&bean.getDealUser()>0){
			criteria.andDealUserEqualTo(bean.getDealUser());
		}if(bean.getShenpileixing()!=null&&bean.getShenpileixing()>0){
			criteria.andShenpileixingEqualTo(bean.getShenpileixing());
		}if(bean.getStatus()!=null&&bean.getStatus()>0){
			criteria.andStatusEqualTo(bean.getStatus());
		}
		return uflowWorkMapper.selectByExample(example);
	}
	@Override
	public int deleteByZhuId(Integer zhuId) {
		UflowWorkExample example=new UflowWorkExample();
		example.createCriteria().andWorkIdEqualTo(zhuId);
		return uflowWorkMapper.deleteByExample(example);
	}
	@Override
	public UflowWork searchById(Integer id) {
	
		return uflowWorkMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateById(UflowWork bean) {
	
		return uflowWorkMapper.updateByPrimaryKeySelective(bean);
	}
	  

}
