package com.ccgj.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.util.StringCode;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Dept;
import com.ccgj.database.beans.Module;
import com.ccgj.database.beans.Position;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.Users;
import com.ccgj.service.inter.DeptService;
import com.ccgj.service.inter.PositionService;
import com.ccgj.service.inter.RoleService;
import com.ccgj.service.inter.UserService;

@Controller
@RequestMapping("dept")
public class DeptController {
   @Autowired
   private DeptService deptService;
   @Autowired
   private UserService userService;
   @Autowired
   private RoleService roleService;
   @Autowired
   private PositionService positionService;
  
   
 
   @RequestMapping("/getDeptTree")
   public @ResponseBody List<Map<String,Object>> getDeptTree(HttpServletRequest request,Integer deptId){
	   List<Map<String,Object>> trees = new ArrayList<Map<String,Object>>();
	   if(deptId==null||deptId<0){
		    List topList=deptService.searchDeptListByPartentId(-1);
			for(int i=0;i<topList.size();i++){
				Dept dept=(Dept) topList.get(i);
				List list=deptService.searchDeptListByPartentId(dept.getId());
				
				Map<String,Object> tree = new HashMap<String, Object>();
				
				tree.put("id", dept.getId());
		        tree.put("text", dept.getDeptname());
		       
		        if(list==null||list.size()==0){
		        	  tree.put("leaf", true);
		        }else{
		        	 tree.put("leaf", false);
		        }
		        	
		        tree.put("iconCls", "add1");
		        trees.add(tree);
			}
	   }else{
		   List deptList=deptService.searchDeptListByPartentId(deptId);
		   if(deptList!= null && deptList.size()>0){
   			for(int i = 0;i<deptList.size();i++){
   				Dept dept = (Dept)deptList.get(i);
   			    List leafList = deptService.searchDeptListByPartentId(dept.getId());
   				int count = leafList.isEmpty()?0:leafList.size();
   				Map<String,Object> tree = new HashMap<String, Object>();
   				tree.put("id", dept.getId());
   				tree.put("text", dept.getDeptname());
   			   
   				tree.put("leaf", count==0);
   			    tree.put("iconCls", "add1");        
   			    trees.add(tree);
   		    }
   	    }
	   }
		
		
		return trees;
   }
   
   
   @RequestMapping("/deptAdd")
   public String deptAdd(Integer parentid,Model model){
	  Dept dept=new Dept();
	  dept.setParentid(parentid);
	   model.addAttribute("dept", dept);
	   return "system/deptAdd";
   }
   @RequestMapping("/deptSave")
   public String deptSave(Integer parentid,Dept dept){
	if(dept.getId()!=null&&dept.getId()>0){
		deptService.updateDeptById(dept.getId(), dept);
	}else{
		 deptService.insertDept(parentid, dept);
	}
	 
	   return "forward:/user/init";
   } 
   @RequestMapping("/deptUpdate")
   public String deptUpdate(Integer deptId,Model model){
	   Dept dept=deptService.searchDeptById(deptId);
	   model.addAttribute("dept", dept);
	  
	   return "system/deptAdd";
   }
   @RequestMapping(value="/deptDelete",produces="text/html;charset=UTF-8")
   public @ResponseBody String deptDelete(HttpServletResponse  response,Integer deptId){

	   List<Dept> deptList=deptService.searchDeptListByPartentId(deptId);
	 
	   List<Users> userList=userService.searchUserListByDeptId(deptId);
	   if(userList!=null&&userList.size()>0){
		   return "该部门下尚有用户，删除失败！";
	   }
	   if(deptList!=null&&deptList.size()>0){
		   for(int i=0;i<deptList.size();i++){
			   List<Users> userList1=userService.searchUserListByDeptId(deptList.get(i).getId());
			   if(userList1!=null&&userList1.size()>0){
				   return "该部门下尚有用户，删除失败！";
			   }
		   }
	   }
	   if(deptList!=null&&deptList.size()>0){
		   for(int i=0;i<deptList.size();i++){
			  deptService.DeleteDeptById(deptList.get(i).getId());
		   }
	   }
	   deptService.DeleteDeptById(deptId);
	   return "删除成功!";
   }
   
   @RequestMapping("/userAdd")
   public String userAdd(Integer deptId,Model model){
	
	 // deptService.insertDept(parentId, dept);
	   List roleList=roleService.searchRoleList();
	   System.out.println("==================="+roleList.size());
	   List positionList=positionService.searchPositionList();
	   model.addAttribute("deptId", deptId);
	   model.addAttribute("roleList", roleList);
	   model.addAttribute("positionList", positionList);
	   return "system/userAdd";
   }
   @RequestMapping("/userSave")
   public String userSave(Users user,Model model){
	  Integer deptId=-1;
	   if(user.getDeptid()!=null&&user.getDeptid()>0){
		   deptId=user.getDeptid();
		   Dept dept= deptService.searchDeptById(user.getDeptid());
		   user.setDeptname(dept.getDeptname());
	   }
	   if(user.getRoleid()!=null&&user.getRoleid()>0){
		   Role role= roleService.searchRoleById(user.getRoleid());
		   user.setRolename(role.getRolename());
	   }
	   if(user.getPositionid()!=null&&user.getPositionid()>0){
		   Position position=positionService.searchPositionById(user.getPositionid());
		   user.setPositionname(position.getName());
	   }
	   if(user.getSex()==1){
		   user.setSexname("男");
	   }if(user.getSex()==2){
		   user.setSexname("女");
	   }
	   user.setFlag(1);
	   user.setEdulead(1);
	   user.setPassword(StringCode.encrypt("123"));	
	   userService.insertUser(user);
	   
	   return "forward: init.action?deptId="+deptId;
   }
   
}
