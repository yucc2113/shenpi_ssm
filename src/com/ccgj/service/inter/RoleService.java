package com.ccgj.service.inter;

import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Role;

public interface RoleService {
	//查询所有角色
     public List<Role> searchRoleList();
     //分页查询角色
     public CommonPage<Role> searchRoleListByPage(Integer pageNo);
     //根据Id查询juese
     public Role searchRoleById(int id);
     //添加一条信息
     public int insert(Role role);
     //更新一条信息
     public int update(int id,Role role);
     //删除一个角色
     public int deleteById(int id);
     
     
}
