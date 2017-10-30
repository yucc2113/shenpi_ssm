package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.Users;
import com.ccgj.database.beans.UsersExample;
import com.ccgj.database.mapper.UsersMapper;
import com.ccgj.service.inter.UserService;
import com.github.pagehelper.PageHelper;


public class UserServiceImp implements UserService {
	@Autowired
    private UsersMapper userMapper;
	@Override
	public List<Users> searchUsers(String userno,String password) {
		System.out.println("hello");
		UsersExample usersExample=new UsersExample();
		System.out.println("hello111");
		usersExample.createCriteria().andUsernoEqualTo(userno).andPasswordEqualTo(password);
		System.out.println("hello222");
		List list= userMapper.selectByExample(usersExample);
		System.out.println("list="+list);
		return list;
	}
	@Override
	public CommonPage<Users> searchUserListByDeptIdWithPage(Integer deptId,Integer pageNum) {
		UsersExample bean=new UsersExample();
		UsersExample.Criteria criteria=bean.createCriteria();
		if(deptId!=null&&deptId>0){
			criteria.andDeptidEqualTo(deptId);
		}
		criteria.andEduleadEqualTo(1);
		criteria.andFlagEqualTo(1);
		
		
		pageNum = pageNum == null?1:pageNum;  
	    int pageSize =10;  
	    PageHelper.startPage(pageNum,pageSize); 
	    List list=userMapper.selectByExample(bean);
	    
		return  (CommonPage<Users>) BeanUtil.toPagedResult(list);
	}
	@Override
	public int insertUser(Users user) {
		
		return userMapper.insert(user);
	}
	@Override
	public List<Users> searchUserListByDeptId(Integer deptId) {
		UsersExample bean=new UsersExample();
		UsersExample.Criteria criteria=bean.createCriteria();
		if(deptId!=null&&deptId>0){
			criteria.andDeptidEqualTo(deptId);
		}criteria.andEduleadEqualTo(1);
		criteria.andFlagEqualTo(1);
		List list=userMapper.selectByExample(bean);
		return list;
	}
	@Override
	public Users searchUserById(Integer id) {
		
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateUserById(Integer id, Users user) {
		user.setId(id);
		return userMapper.updateByPrimaryKey(user);
	}
	@Override
	public int deleteUserById(Integer id) {
		
		return userMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<Users> searchUserList() {
		UsersExample bean=new UsersExample();
		bean.createCriteria().andFlagEqualTo(1);
		return userMapper.selectByExample(bean);
	}
	

}
