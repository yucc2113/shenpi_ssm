package com.ccgj.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.base.common.util.DateFormat;
import com.base.common.util.GlobalDefine;
import com.base.common.util.StringCode;
import com.base.common.util.SystemUtil;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.Users;
import com.ccgj.service.inter.SystemlogService;
import com.ccgj.service.inter.UserRoleService;
import com.ccgj.service.inter.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private SystemlogService systemlogService;
    
	@RequestMapping("/toLogin")
	public @ResponseBody Map<String, String> toLogin(HttpServletRequest request, String loginName,String loginPwd) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> map = new HashMap<String, String>();
		Users user = new Users();
		String pass = StringCode.encrypt(loginPwd);
		if (null == loginName || null == loginPwd) {
			map.put("success", "false:用户名或密码不能为空!");
		}
		System.out.println("hi");
		List<Users> list = userService.searchUsers(loginName, pass);
		System.out.println(list);
		if (list != null && list.size() > 0) {// 该用户存在
			user = list.get(0);
		  
			//List<Role> roleList = userRoleService.findRoleByUserId(user.getId());
			//if (roleList != null && roleList.size() > 0) {// 有角色
		   	if (user.getRoleid() != null &&user.getRoleid() > 0) {// 有角色
				request.getSession().setAttribute(GlobalDefine.USER, user);
				systemlogService.insertSystemlog(user.getUsername(),user.getId(),"登陆系统");

				
				map.put("success", "true");
			} else {// 无角色
				map.put("success", "false:未赋予该用户任何角色!");
			}
		} else {
			map.put("success", "false:用户名或密码错误!");
		}
		System.out.println("22222");
		return map;
	}
	@RequestMapping("/login")
    public String login(Users user,Model model,HttpServletRequest request){
         return "redirect:/index.jsp";

    }
	  @RequestMapping("/logout")
	   public  String logout(HttpServletRequest request){
		  if(request.getSession().getAttribute(GlobalDefine.USER)!=null){
			  request.getSession().setAttribute(GlobalDefine.USER, null);
			}
			return "redirect:/login.jsp";
	   }
}
