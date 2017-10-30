package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.RoleModule;
import com.ccgj.database.beans.RoleModuleExample;
import com.ccgj.database.mapper.RoleModuleMapper;
import com.ccgj.service.inter.RoleModuleService;

public class RoleModuleServiceImp implements RoleModuleService {
    @Autowired
    private RoleModuleMapper roleModuleMapper;
	@Override
	public List<RoleModule> searchRoleModuleListByRoleIdAndModuleId(Integer roleId,
			Integer moduleId) {
		RoleModuleExample bean=new RoleModuleExample();
		RoleModuleExample.Criteria criteri=bean.createCriteria();
		criteri.andRoleidEqualTo(roleId);
		criteri.andModuleidEqualTo(moduleId);
		return roleModuleMapper.selectByExample(bean);
	}
	@Override
	public List<RoleModule> searchRoleModuleListByRoleId(Integer roleId) {
		RoleModuleExample bean=new RoleModuleExample();
		bean.createCriteria().andRoleidEqualTo(roleId);
		
		return roleModuleMapper.selectByExample(bean);
	}
	@Override
	public RoleModule searchRoleModuleById(Integer id) {
		
		return roleModuleMapper.selectByPrimaryKey(id);
	}
	@Override
	public int deleteRoleModuleById(Integer id) {
		return roleModuleMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int insertRoleModule(RoleModule roleModule) {
		
		return roleModuleMapper.insert(roleModule);
	}

}
