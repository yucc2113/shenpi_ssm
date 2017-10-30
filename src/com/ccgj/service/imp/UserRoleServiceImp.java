package com.ccgj.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Module;
import com.ccgj.database.beans.ModuleExample;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.RoleModule;
import com.ccgj.database.beans.RoleModuleExample;
import com.ccgj.database.beans.UserRole;
import com.ccgj.database.beans.UserRoleExample;
import com.ccgj.database.beans.Users;
import com.ccgj.database.mapper.ModuleMapper;
import com.ccgj.database.mapper.RoleMapper;
import com.ccgj.database.mapper.RoleModuleMapper;
import com.ccgj.database.mapper.UserRoleMapper;
import com.ccgj.database.mapper.UsersMapper;
import com.ccgj.service.inter.UserRoleService;

public class UserRoleServiceImp implements UserRoleService{
	@Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
	private UsersMapper userMapper;
    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private RoleModuleMapper roleModuleMapper;
	 /**
     * 查询用户所具有的角色
     */
 	@Override
 	public List<Role> findRoleByUserId(Integer userId) {
 		UserRoleExample userRoleExample = new UserRoleExample();
 		userRoleExample.or().andUseridEqualTo(userId);
 		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
 		List<Role> roleList=new ArrayList<Role>();
 		for(int i=0;i<userRoleList.size();i++){
 			roleList.add(roleMapper.selectByPrimaryKey(userRoleList.get(i).getRoleid()));
 		}
 		return roleList;
 	}
 	
 	/**
 	 * 查询属于该角色的所有用户
 	 */
	@Override
	public List<Users> findUserByRoleId(Integer roleId) {
		UserRoleExample userRoleExample = new UserRoleExample();
 		userRoleExample.or().andRoleidEqualTo(roleId);
 		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
 		List<Users> userList=new ArrayList<Users>();
 		for(int i=0;i<userRoleList.size();i++){
 			userList.add(userMapper.selectByPrimaryKey(userRoleList.get(i).getUserid()));
 		}
 		return userList;
	}
	
	/**
	 * <p>Title: getAuthorityById</p>
	 * <p>Description:查询用户所具有的栏目权限 </p>
	 * @param userId
	 * @return
	 */
	@Override
	public List<Module> getUserModuleByUserId(Integer userId) {
		//用户所具有的角色
		List<Role> roleList=findRoleByUserId(userId);
		List<Integer> roleIdList=new ArrayList<Integer>();
		
		for(int i=0;i<roleList.size();i++){
			roleIdList.add(roleList.get(i).getId());	
		}
		//根据用户角色查询出角色具有的菜单权限
		RoleModuleExample roleModuleExample=new RoleModuleExample();
		roleModuleExample.createCriteria().andRoleidIn(roleIdList);
		List<RoleModule> roleMenuList=roleModuleMapper.selectByExample(roleModuleExample);
		List<Integer> moduleIdList=new ArrayList<Integer>();
		for(int i=0;i<roleMenuList.size();i++){
			moduleIdList.add(roleMenuList.get(i).getModuleid());
		}
		//根据菜单Id查询出菜单信息
		ModuleExample moduleExample=new ModuleExample();
		moduleExample.createCriteria().andIdIn(moduleIdList);
		List<Module> moduleList=moduleMapper.selectByExample(moduleExample);
		
		return moduleList;
	}
}
