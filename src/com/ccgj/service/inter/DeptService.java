package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.Dept;

public interface DeptService {
	public List<Dept> searchDeptListByPartentId(int parentId);
	public int insertDept(int parentId,Dept dept);
	public Dept searchDeptById(Integer id);
	public int updateDeptById(Integer id,Dept dept);
	public int DeleteDeptById(Integer id);

}
