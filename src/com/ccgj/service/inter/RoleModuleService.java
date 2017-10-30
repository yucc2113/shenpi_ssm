package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.RoleModule;

public interface RoleModuleService {
	
   public List<RoleModule> searchRoleModuleListByRoleIdAndModuleId(Integer roleId,Integer moduleId);
   
   public List<RoleModule> searchRoleModuleListByRoleId(Integer roleId);
   
   public RoleModule searchRoleModuleById(Integer id);
   
   public int  deleteRoleModuleById(Integer id);
   
   public int  insertRoleModule(RoleModule roleModule);
}
