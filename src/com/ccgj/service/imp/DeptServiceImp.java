package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Dept;
import com.ccgj.database.beans.DeptExample;
import com.ccgj.database.mapper.DeptMapper;
import com.ccgj.service.inter.DeptService;

public class DeptServiceImp implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
	@Override
	public List<Dept> searchDeptListByPartentId(int parentId) {
		DeptExample bean=new DeptExample();
		bean.createCriteria().andParentidEqualTo(parentId);
		return deptMapper.selectByExample(bean);
	}
	@Override
	public int insertDept(int parentId, Dept dept) {
		dept.setParentid(parentId);
		return deptMapper.insert(dept);
		
	}
	@Override
	public Dept searchDeptById(Integer id) {
		return deptMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateDeptById(Integer id,Dept dept) {
		dept.setId(id);
		return deptMapper.updateByPrimaryKey(dept);
	}
	@Override
	public int DeleteDeptById(Integer id) {
		
		return deptMapper.deleteByPrimaryKey(id);
	}

}
