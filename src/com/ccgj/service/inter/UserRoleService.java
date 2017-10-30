package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.Module;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.Users;



public interface UserRoleService {
	//根据用户ID查询该用户的角色
	public List<Role> findRoleByUserId(Integer userId);
	// 查询属于该角色的所有用户
	public List<Users> findUserByRoleId(Integer roleId);
	//根据用户ID查询该用户具有的栏目权限
	public List<Module> getUserModuleByUserId(Integer userId) ;
}
