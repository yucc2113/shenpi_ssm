package com.ccgj.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.common.util.GlobalDefine;
import com.ccgj.database.beans.Module;
import com.ccgj.database.beans.Users;
import com.ccgj.database.custom.beans.ModuleCustom;
import com.ccgj.database.custom.mapper.UserModuleCustomMapper;
import com.ccgj.service.inter.ModuleService;
import com.ccgj.service.inter.UserModuleService;
import com.ccgj.service.inter.UserRoleService;

@Controller
public class MenuController {
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private UserModuleService userModuleService;
	
	@RequestMapping("/menu/initMenu")
    public String initMenu(Model model,HttpServletRequest request){
		 String content = "";
		 Users tUser= (Users)request.getSession(true).getAttribute(GlobalDefine.USER);
		 Integer role_id = tUser.getRoleid();
		 List<Module> topMenu=userModuleService.searchModuleByRoleIdAndParentId(role_id, 2);
		 if(topMenu!=null&&topMenu.size()>0){
			 content+="<ul>";
				for(int i=0;i<topMenu.size();i++){
					content +="<li><p class='menu01 left_menu_01'><b class='bg01'>"+topMenu.get(i).getName()+"</b><a href='#' class='show_a a02'></a></p>";
					if(i==0){
						content +="<ul>";
					}else{
						content +="<ul style='display:none;'>";
					}
					List<Module> secondMenu = userModuleService.searchModuleByRoleIdAndParentId(role_id, topMenu.get(i).getId());
					if(secondMenu!=null&&secondMenu.size()>0){
						for(int j=0;j<secondMenu.size();j++){
							
							List<Module> threeMenu = userModuleService.searchModuleByRoleIdAndParentId(role_id, secondMenu.get(j).getId());
								if(threeMenu!=null&&threeMenu.size()>0){
									content +="<li>";
									content +="<div class='hover'>";
									content +="<p class='add_p left_menu_02 end_collapsable'></p><p class='folder_p folder_collapsable'></p>";
									content +="<a href='#' class='left_menu_02'>"+secondMenu.get(j).getName()+"</a>";
									content +="</div>";
									content +="<ul>";
									for(int h=0;h<threeMenu.size();h++){
										content +="<li>";
										content +="<div class='hover'><p class='node'></p><p class='file'></p>";
										content +="<a href='"+ request.getContextPath()+"/"+threeMenu.get(h).getConurl()+"' target='centerFrame'>"+threeMenu.get(h).getName()+"</a>";
										content +="</div>";
										content +="</li>";
									}
									content +="</ul>";
									content +="</li>";
								}
							
						}
					}
					content +="</ul>";
				}
				content+="</ul>";
		 }
		 model.addAttribute("leftMenu", content);
		
		 return "forward:/inc/leftMenu.jsp";
	}
}
