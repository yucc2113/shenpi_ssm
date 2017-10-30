package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.RoleExample;
import com.ccgj.database.mapper.RoleMapper;
import com.ccgj.service.inter.RoleService;
import com.github.pagehelper.PageHelper;

public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> searchRoleList() {
	   RoleExample bean=new RoleExample();
	   bean.createCriteria().andFlagEqualTo(1);
		return  roleMapper.selectByExample(bean);
	}
	@Override
	public CommonPage<Role> searchRoleListByPage(Integer pageNo) {
		pageNo = pageNo == null?1:pageNo;  
	    int pageSize =10;  
	    PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
	    List<Role> list=searchRoleList();
	    return (CommonPage<Role>) BeanUtil.toPagedResult(list); 
	}
	@Override
	public int insert(Role role) {
		role.setFlag(1);
		return roleMapper.insert(role);
	}
	@Override
	public Role searchRoleById(int id) {
		return roleMapper.selectByPrimaryKey(id);
	}
	@Override
	public int update(int id, Role role) {
		role.setId(id);
		return roleMapper.updateByPrimaryKey(role);
		
	}
	@Override
	public int deleteById(int id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

}
