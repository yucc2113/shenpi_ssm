package com.ccgj.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.util.GlobalDefine;
import com.base.common.util.SystemUtil;
import com.ccgj.database.beans.Module;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.RoleModule;
import com.ccgj.database.beans.Users;
import com.ccgj.service.inter.ModuleService;
import com.ccgj.service.inter.RoleModuleService;
import com.ccgj.service.inter.RoleService;
import com.ccgj.service.inter.SystemlogService;

@Controller
@RequestMapping("roleModule")
public class RoleModuleController {
    @Autowired
    private RoleModuleService roleModuleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModuleService moduleService;
    
    @Autowired
    private SystemlogService systemlogService;
    @RequestMapping("/init")
    public String init(){
    	return "system/roleModule";
    }
    /**
     * 角色树
     * @return
     */
    @RequestMapping("/getRoleTree")
    public @ResponseBody List<Map<String,Object>> getRoleTree(Integer roleId,Integer parentId){
    	List<Map<String,Object>> trees = new ArrayList<Map<String,Object>>();
        List roleList=roleService.searchRoleList();
        if(roleList!= null && roleList.size()>0){
        	for(int i = 0 ; i <roleList.size(); i++){
				Role searchRole = (Role)roleList.get(i);
				Map<String,Object> tree = new HashMap<String, Object>();
				tree.put("id", searchRole.getId());
		        tree.put("text", searchRole.getRolename());
		        tree.put("leaf", true);
		        trees.add(tree);
			}
        }
    	return trees;
    }
    @RequestMapping("/getModuleTree")
    public @ResponseBody List<Map<String,Object>> getModuleTree(Integer roleId,Integer parentId){
    	List<Map<String,Object>> trees = new ArrayList<Map<String,Object>>();
    	if(parentId!=null && parentId<0){
    		//创建节点
    		
    		//查询顶级的栏目
    		List<Module> moduleList=moduleService.searchModuleListByParentId(2);
    		if(moduleList!= null && moduleList.size()>0){
				for(int i = 0 ; i <moduleList.size(); i++){
					Module searchModule = (Module)moduleList.get(i);
					Map<String,Object> tree = new HashMap<String, Object>();
					tree.put("id", searchModule.getId());
			        tree.put("text", searchModule.getName());
			        tree.put("leaf", false);
			        
			        if(roleId!=null&&roleId>0){
			        	List list=roleModuleService.searchRoleModuleListByRoleIdAndModuleId(roleId, searchModule.getId());
			        	if(list!= null && list.size()>0){
			        		tree.put("checked", true);	
			        	}
			        }
			        
			        trees.add(tree);
				}
    		}
    	}else{
    	    List moduleList=moduleService.searchModuleListByParentId(parentId);
    		if(moduleList!= null && moduleList.size()>0){
    			for(int i = 0;i<moduleList.size();i++){
    				Module searchModule = (Module)moduleList.get(i);
    			    List leafList = moduleService.searchModuleListByParentId(searchModule.getId());
    				int count = leafList.isEmpty()?0:leafList.size();
    				Map<String,Object> tree = new HashMap<String, Object>();
    				tree.put("id", searchModule.getId());
    				tree.put("text", searchModule.getName());
    				tree.put("leaf", count==0);
    				if(roleId!=null&&roleId>0){
    					List list=roleModuleService.searchRoleModuleListByRoleIdAndModuleId(roleId, searchModule.getId());
			        	if(list!= null && list.size()>0){
			        		tree.put("checked", true);	
			        	}
    			   }	        
    			   trees.add(tree);
    		    }
    	    }
    		
         }
    	return trees;
    }
    @RequestMapping("/roleModuleSave")
    public String moduleRoleSave(HttpServletRequest request,String moduleIds, Integer byId){
    	String[] ids = moduleIds.split(",");
    	System.out.println("ids.length=================="+ids.length);
    	System.out.println("byId=================="+byId);
    	if(byId!=null&&byId>0){
    		
    			List<RoleModule> mList=roleModuleService.searchRoleModuleListByRoleId(byId);
    			if(mList!=null&&mList.size()>0){
					for(RoleModule rolebean : mList){
						RoleModule tRoleModule1= roleModuleService.searchRoleModuleById(rolebean.getId());
						System.out.print("i am here");
						roleModuleService.deleteRoleModuleById(tRoleModule1.getId());
					}
    			}
    			System.out.println("=================="+ids.length);
    			for(int i=0;i<ids.length;i++){
					if(ids[i]!=null&&!ids[i].equals("")){
					    RoleModule bean= new RoleModule();
					    bean.setRoleid(new Integer(byId));
					    bean.setModuleid(Integer.valueOf(ids[i].trim()));
					    roleModuleService.insertRoleModule(bean);
					}
				}
			
    	}
    	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
    	systemlogService.insertSystemlog(user.getUsername(),user.getId(),"修改人员权限");

    	return "forward:init";
    }
}
