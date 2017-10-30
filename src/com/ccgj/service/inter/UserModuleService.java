package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.Module;

public interface UserModuleService {
	public List<Module> searchModuleByRoleIdAndParentId(Integer roleId,Integer parentId);
}
