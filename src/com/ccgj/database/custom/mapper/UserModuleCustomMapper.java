package com.ccgj.database.custom.mapper;

import java.util.List;

import com.ccgj.database.beans.Module;

public interface UserModuleCustomMapper {
    public List<Module>  searchModuleByRoleIdAndParentId(Integer roleId,Integer parentId);
}
