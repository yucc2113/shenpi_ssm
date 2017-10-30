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

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Dept;
import com.ccgj.database.beans.Role;
import com.ccgj.service.inter.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
    private RoleService roleService;
	/**
	 * 初始化角色列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/roleList")
	public String  roleList(Model model){
		CommonPage<Role> commonPage=roleService.searchRoleListByPage(null);
		model.addAttribute("commonPage", commonPage);
		return "system/roleList";
	}
	/**
	 * ajax请求角色列表的分页信息
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/ajaxRoleList")
	public @ResponseBody CommonPage<Role> ajaxRoleList(Integer pageNo){
		if(pageNo==null||pageNo==0) pageNo=1;
		CommonPage<Role> commonPage=roleService.searchRoleListByPage(pageNo);
		return commonPage;
	}
	/**
	 * 跳转到角色添加页面
	 * @return
	 */
	@RequestMapping("/roleAdd")
	public String roleAdd(){
		return "system/roleAdd";
	}
	/**
	 * 角色信息保存
	 * @param role
	 * @return
	 */
	@RequestMapping("/roleSave")
	public  String roleSave(Role role){
		if(role.getId()!=null&&role.getId()>0){
			Role bean=roleService.searchRoleById(role.getId());
			bean.setRolename(role.getRolename());
		
			roleService.update(role.getId(), bean);
		}
		else roleService.insert(role);
		return "forward:roleList";
	}
	/**
	 * 跳转到角色信息更新页面
	 * @param role
	 * @return
	 */
	@RequestMapping("/roleUpdate")
	public  String roleUpdate(Integer id,Model model){
		Role role=roleService.searchRoleById(id);
		model.addAttribute("role", role);
		return "system/roleAdd";
	}
	@RequestMapping("/roleDelete")
	public  String roleDelete(HttpServletResponse response, Integer[] ids){
		response.setCharacterEncoding("utf-8");
		for(int i=0;i<ids.length;i++){
			int id=ids[i];
			roleService.deleteById(id);
		}
		return "forward:roleList";
	}
	
	
	
	
	@RequestMapping("/getRoleTree")
	public @ResponseBody List<Map<String, Object>> getRoleTree(HttpServletRequest request,
			Integer roleId) {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();

		List roleList = roleService.searchRoleList();

	
		for (int i = 0; i < roleList.size(); i++) {
			Map<String,Object> tree = new HashMap<String, Object>();
			Role role = (Role) roleList.get(i);
			tree.put("id", role.getId());
			tree.put("text", role.getRolename());
			tree.put("leaf", true);
			trees.add(tree);
		}

		return trees;
	}
}
