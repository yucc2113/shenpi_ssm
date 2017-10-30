package com.ccgj.service.inter;

import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Users;

public interface UserService {
   public List<Users> searchUsers(String userno,String password);
   
   public CommonPage<Users> searchUserListByDeptIdWithPage(Integer deptId,Integer pageNum);

   public List<Users> searchUserListByDeptId(Integer deptId);
   
   public Users searchUserById(Integer id);
   public List<Users> searchUserList();
   public int insertUser(Users user);
   public int updateUserById(Integer id,Users user);
   
   public int deleteUserById(Integer id);
   
}
