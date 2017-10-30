package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.Module;



public interface ModuleService {
	 //查询菜单
	   public List<Module> searchModuleListByParentId(Integer parentId);
}
