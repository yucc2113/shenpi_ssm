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

import com.base.common.util.GlobalDefine;
import com.base.common.util.StringCode;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Dept;
import com.ccgj.database.beans.Dict;
import com.ccgj.database.beans.Position;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.Users;
import com.ccgj.service.inter.DeptService;
import com.ccgj.service.inter.PositionService;
import com.ccgj.service.inter.RoleService;
import com.ccgj.service.inter.UserService;

@Controller
@RequestMapping("user")
public class UserController {
   @Autowired
   private UserService userService;
   @Autowired
   private RoleService roleService;
   @Autowired
   private PositionService positionService;
   @Autowired
   private DeptService deptService;
   
   @RequestMapping("/init")
   public String init(Model model,Integer deptId){
	 
	   CommonPage<Users> commonPage=userService.searchUserListByDeptIdWithPage(deptId,null);
	   System.out.println(commonPage.getDataList().size());
	   model.addAttribute("commonPage", commonPage);
	   return "system/deptList";
   }

   @RequestMapping("/ajaxUserList")
   public @ResponseBody CommonPage<Users> ajaxUserList(Model model,Integer deptId,Integer pageNum){
	 
	   CommonPage<Users> commonPage=userService.searchUserListByDeptIdWithPage(deptId,pageNum);
	  
	   return commonPage;
   }
   
   @RequestMapping("/userAdd")
   public String userAdd(Integer deptId,Model model){
	   List roleList=roleService.searchRoleList();
	 
	   List positionList=positionService.searchPositionList();
	   model.addAttribute("deptId", deptId);
	   model.addAttribute("roleList", roleList);
	   model.addAttribute("positionList", positionList);
	   return "system/usersAdd";
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
	   
	   if(user.getId()!=null&&user.getId()>0){
		   userService.updateUserById(user.getId(), user);
	   }else{
		   userService.insertUser(user); 
	   }
	  
	   
	   return "forward:init.action?deptId="+deptId;
   }
   
   @RequestMapping("/userUpdate")
   public String userUpdate(Integer id,Model model){
	    Users user=userService.searchUserById(id);
		
		
		
	   List roleList=roleService.searchRoleList();
	   List positionList=positionService.searchPositionList();
	   
	   model.addAttribute("deptId", user.getDeptid());
	   model.addAttribute("user",user);
	   model.addAttribute("roleList", roleList);
	   model.addAttribute("positionList", positionList);
	   return "system/usersAdd";
   }
   
   @RequestMapping("/userDelete")
   public String userDelete(Integer[] ids,Model model){
	    
	    for(int i=0;i<ids.length;i++){
			int id=ids[i];
			Users user=userService.searchUserById(id);
			user.setFlag(2);
			userService.updateUserById(id, user);
		}
		return "forward: init";
		
	  
   }
   @RequestMapping("/toUpdatePsw")
   public String toUpdatePsw(Model model){
	   
		return "system/updatePsw";
		
	  
   }
   @RequestMapping("/updatePsw")
   public @ResponseBody String updatePsw(HttpServletRequest request,String oldpsw,String newpsw){
	   Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
	   if(!user.getPassword().equals(StringCode.encrypt(oldpsw))){
		   return "-1";
	   }
	   else{
		   user.setPassword(StringCode.encrypt(newpsw));
		   userService.updateUserById(user.getId(), user);
	   }
		return "1";
   }
  
   /**
    * 得到带有部门的用户树
    * 改变部门及人员的编码(部门以1开头，人员以2开头)
    * @param request
    * @param deptId
    * @return
    */
   
   @RequestMapping("/getUserTreeWithDept")
   public @ResponseBody List<Map<String,Object>> getUserTreeWithDept(HttpServletRequest request,Integer deptId){
	  
	   List<Map<String,Object>> trees = new ArrayList<Map<String,Object>>();
	   if(deptId==null||deptId<0){
		    List topList=deptService.searchDeptListByPartentId(-1);
			for(int i=0;i<topList.size();i++){
				Dept dept=(Dept) topList.get(i);
				List list=deptService.searchDeptListByPartentId(dept.getId());
				List userList=userService.searchUserListByDeptId(dept.getId());
				Map<String,Object> tree = new HashMap<String, Object>();
				Integer oldId=dept.getId();
   				Integer newId=Integer.parseInt("1"+oldId);
				tree.put("id", newId);
		        tree.put("text", dept.getDeptname());
		       
		        if((list==null||list.size()==0)&&(userList==null||userList.size()==0)){
		        	  tree.put("leaf", false);
		        }else{
		        	 tree.put("leaf", false);
		        }
		        	
		        tree.put("iconCls", "add1");
		        trees.add(tree);
			}
	   }else{
		   deptId=Integer.parseInt((deptId+"").substring(1));
		   List deptList=deptService.searchDeptListByPartentId(deptId);
		   List userList=userService.searchUserListByDeptId(deptId);
		   if(deptList!= null && deptList.size()>0){
   			 for(int i = 0;i<deptList.size();i++){
   				Dept dept = (Dept)deptList.get(i);
   			    List leafList = deptService.searchDeptListByPartentId(dept.getId());
   				int count = leafList.isEmpty()?0:leafList.size();
   				Map<String,Object> tree = new HashMap<String, Object>();
   				//部门id以1开头
   				Integer oldId=dept.getId();
   				Integer newId=Integer.parseInt("1"+oldId);
   				tree.put("id", newId);
   				tree.put("text", dept.getDeptname());
   			   
   				tree.put("leaf", false);
   			    tree.put("iconCls", "add1");        
   			    trees.add(tree);
   		    }
   	      }
		  if(userList!=null&&userList.size()>0){
			  for(int i = 0;i<userList.size();i++){
	   				Users user = (Users)userList.get(i);
	   			   
	   				Map<String,Object> tree = new HashMap<String, Object>();
	   				//用户ID以2开头
	   				Integer oldId=user.getId();
	   				Integer newId=Integer.parseInt("2"+oldId);
	   				tree.put("id", newId);
	   				tree.put("text", user.getUsername());
	   			   
	   				tree.put("leaf", true);
	   			    tree.put("iconCls", "add");        
	   			    trees.add(tree);
	   		    }
		  }
	   }
		
		
		return trees;
   }
   
   @RequestMapping("/getUserTree")
   public @ResponseBody List<Map<String,Object>> getUserTree(HttpServletRequest request){
	   List<Map<String,Object>> trees = new ArrayList<Map<String,Object>>();
		List userList=userService.searchUserList();
		if(userList!=null&&userList.size()>0){
			
			for(int i=0;i<userList.size();i++){
				Users user = (Users)userList.get(i);
				Map<String, Object> tree = new HashMap<String, Object>();

				tree.put("id", user.getId());
				tree.put("text", user.getUsername());
				tree.put("leaf", true);
   			    tree.put("iconCls", "add");  
   			    trees.add(tree);
			}
		}
		
		return trees;
   }
   /**
	 * 跳转到查询通知人员的页面
	 * @return
	 */
	@RequestMapping("/searchUser")
   public String  searchUser(){
		return "user/searchNoticeUser";
	}
	/**
	 * 查询出通知人员的人数
	 * @param response
	 * @param usersId：页面传来的参数(usersId是未经编码的，由于该值在前台已经转换成功)
	 * @return
	 */
	@RequestMapping(value="/selectnum",produces={"text/html;charset=UTF-8;","application/json;"})
   public @ResponseBody String  selectnum(HttpServletResponse response,String usersId){
		
		/*response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");*/
		String [] ids = usersId.split(",");
		String usersName="";
		System.out.println("***************8"+usersId+"   "+ids.length);
		for(int i = 0;i <ids.length; i++){
			System.out.println("ids[0]="+ids[i]);
			 Users user= userService.searchUserById(Integer.parseInt(ids[i]));
			 if(usersName.length()>0){
				 usersName+=",";
			 }
			 usersName+=user.getUsername();
		}
		String msg = ids.length+"+"+usersName;	
		System.out.println("============"+usersName);
		return msg;
	}
   
	 /**
		 * 跳转到查询公文人员的页面
		 * @return
		 */
		@RequestMapping("/searchOfficialUser")
	   public String  searchOfficialUser(){
	
			return "user/searchOfficialUser";
		}
		
		@RequestMapping("/searchDept")
	   public String  searchDept(){
			return "user/searchDept";
		}
		
		@RequestMapping("/searchUserForStep")
		public String  searchUserForStep(){
			return "user/searchUser";
		}
		@RequestMapping("/searchRole")
		public String  searchRole(){
			return "user/searchRole";
		}
		@RequestMapping("/searchPosition")
		public String  searchPosition(){
			return "user/searchPosition";
		}
		
}
