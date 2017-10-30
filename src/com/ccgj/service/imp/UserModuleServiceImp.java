package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Module;
import com.ccgj.database.custom.mapper.UserModuleCustomMapper;
import com.ccgj.service.inter.UserModuleService;


public class UserModuleServiceImp implements UserModuleService{
	@Autowired
    private UserModuleCustomMapper userModuleCustomMapper;
	
	public List<Module> searchModuleByRoleIdAndParentId(Integer roleId,Integer parentId){
		List<Module> list= userModuleCustomMapper.searchModuleByRoleIdAndParentId(roleId,parentId);
		return list;
	}
}
