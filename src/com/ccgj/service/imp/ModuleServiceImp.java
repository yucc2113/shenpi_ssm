package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Module;
import com.ccgj.database.beans.ModuleExample;
import com.ccgj.database.mapper.ModuleMapper;
import com.ccgj.service.inter.ModuleService;

public class ModuleServiceImp implements ModuleService{
    @Autowired
    private ModuleMapper moduleMapper;
	

	@Override
	public List<Module> searchModuleListByParentId(Integer parentId) {
		ModuleExample bean=new ModuleExample();
		ModuleExample.Criteria criteria=bean.createCriteria();
		criteria.andParentidEqualTo(parentId);
		criteria.andTypeidEqualTo(1);
		return moduleMapper.selectByExample(bean);
	}

}
