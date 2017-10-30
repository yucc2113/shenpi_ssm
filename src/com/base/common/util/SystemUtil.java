package com.base.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;


import com.ccgj.database.beans.Dept;
import com.ccgj.database.beans.Dict;
import com.ccgj.database.beans.FlowDefine;
import com.ccgj.database.beans.Role;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.database.beans.Users;




public class SystemUtil {
	/**
	 * 判断答案是否被选中
	 * @param value
	 * @param bol
	 * @return
	 */
	public static boolean toCheck(Long value,int type){
		boolean values = false;
		if (type==1) {//选项A
			if(value==1l||value==3l||value==6l||value==8l||value==10l||value==12l||value==15l||value==17l){
				values=true;
			}
		}else if (type==2) {//选项B
			if(value==2l||value==3l||value==7l||value==8l||value==11l||value==12l||value==16l||value==17l){
				values=true;
			}
		}else if (type==3) {//选项C
			if(value==5l||value==6l||value==7l||value==8l||value==12l||value==14l||value==16l||value==17l){
				values=true;
			}
		}else if (type==4) {//选项D
			if(value==9l||value==10l||value==11l||value==12l||value==14l||value==15l||value==16l||value==17l){
				values=true;
			}
		}
			return values;
		}	
	
	/**
	 * 字符过长截取
	 * @param str
	 * @return
	 */	
	public static String trim(String str) {
		if (str != null)
		{
			if (str.length() > 14) {
				return str.substring(0, 10) + "...";
			} else {
				return str;
			}
		}
		else 
			return "";
	}
	
	/**
	 * 字符过长截取
	 * @param str
	 * @return
	 */	
	public static String trim15(String str) {
		if (str != null)
		{
			if (str.length() > 15) {
				return str.substring(0, 15) + "...";
			} else {
				return str;
			}
		}
		else 
			return "";
	}
	
	 /**
	 * 判断一个字符串是否在一个数组内
	 * 
	 * 
	 */
		public static int getIndex(String[] strs,String str){
				for(int i=0;i<strs.length;i++){
					if(str.equals(strs[i])){
						return i;
					}
				}
				return -1;
			}
		
		
		public static int getIndex1(List<Users> strs,String str){
			for(int i=0;i<strs.size();i++){
				Users users = (Users)strs.get(i);
				if((""+users.getId()).equals(str)){
					return i;
				}
			}
			return -1;
		}
 
	/**
	 * 根据ID取字典prop
	 * @param id
	 * @return
	 */
/*	public static String getProp(Long id){
		try {
	//		DictIF dictIF = DatabaseFactory.getDictIF();
			if(id!=null){
				if(id>0){
					Dict dict=dictIF.searchDictByID(id);
					if(dict!=null){
						return dict.getProp();
					}
				}
			}else{
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "";
	}
	*/
		public static String getFormProperties(String pro){
			Properties prop= new Properties();
			try {
				//读取配置文件的路径,配置文件移动,需要更改此处
				String filename=SystemUtil.class.getResource("/").getPath();
				filename=filename.replaceAll("%20", " ");
				filename=filename.substring(0, filename.length()-17);
				filename=filename+("/WEB-INF/properties/configure.properties");
				File profile = new File(filename);
				
				prop.load(new FileInputStream(profile));
				return prop.getProperty(pro);
	//			return ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"";
			}
			catch(Exception e) {
				return "234";
			}
		}
		
		/**
		 * 查询字典
		 * @param contents
		 * @param usersBean
		 */
	/*	public static List dictList(String types)
		{
			List<Dict> dictlist = null;
			try {
				DictIF tDictIF = DatabaseFactory.getDictIF();
				Dict bean = tDictIF.createDict();
				bean.setTypes(types);
				bean.setFlag(1l);
				dictlist = tDictIF.searchDict(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dictlist;
		}
		
		*/
		/**
		 * 查询字典
		 * @param contents
		 * @param usersBean
		 */
		/*public static List roleList()
		{
			List<Role> rolelist = null;
			try {
				RoleIF tRoleIF = DatabaseFactory.getRoleIF();
				Role bean = tRoleIF.createRole();
				rolelist = tRoleIF.searchRole(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rolelist;
		}
		
		*/
		/**
		 * 根据ID取字典prop
		 * @param id
		 * @return
		 */
/*		public static String getRoleName(Long id){
			try {
				RoleIF roleIF = DatabaseFactory.getRoleIF();
				if(id!=null){
					if(id>0){
						Role role=roleIF.searchRoleByID(id);
						if(role!=null){
							return role.getRolename();
						}
					}
				}else{
					return "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  "";
		}
		*/
		
		/**
		 * 查询字典
		 * @param contents
		 * @param usersBean
		 */
	/*	public static List deptList()
		{
			List<Dept> rolelist = null;
			try {
				DeptIF tDeptIF = DatabaseFactory.getDeptIF();
				Dept bean = tDeptIF.createDept();
				bean.setRemark2("1");
				rolelist = tDeptIF.searchDept(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rolelist;
		}*/
		
		/**
		 * 根据ID取字典prop
		 * @param id
		 * @return
		 */
	/*	public static String getDeptName(Long id){
			try {
				DeptIF roleIF = DatabaseFactory.getDeptIF();
				if(id!=null){
					if(id>0){
						Dept role=roleIF.searchDeptByID(id);
						if(role!=null){
							return role.getDeptname();
						}
					}
				}else{
					return "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  "";
		}
		*/
		/**
		 * 根据ID取人员名称
		 * @param id
		 * @return
		 */
	/*	public static String getUsersName(Long id){
			try {
				UsersIF tUsersIF = DatabaseFactory.getUsersIF();
				if(id!=null){
					if(id>0){
						Users role=tUsersIF.searchUsersByID(id);
						if(role!=null){
							return role.getUsername();
						}
					}
				}else{
					return "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  "";
		}*/
	    /**
	     * 根所标识读取审核状态
	     * 
	     * @param pState
	     * @param pType
	     * @return
	     */
	    public static String stockKeState(Long pType) {
		String RetAuditState = "";
		if (pType != null) {
		    if (pType == 1l) {
			RetAuditState = "未处理";
		    }
		    if (pType == 2l) {
			RetAuditState = "转发";
		    }
		    if (pType == 3l) {
				RetAuditState = "办结";
			}
		}
		return RetAuditState;
	    }
	    
	  /*  public static void systemlogSave(String content) {
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Users user = (Users)ActionContext.getContext().getSession().get(GlobalDefine.USER);
				SystemlogIF tSystemlogIF = DatabaseFactory.getSystemlogIF();
				Systemlog searchbean = tSystemlogIF.createSystemlog();
				searchbean.setCreatuserid(user.getId());
				searchbean.setCreatusername(user.getUsername());
				searchbean.setLogcontent(content);
				searchbean.setCreatdate(sdf.parse(sdf.format(new Date())));
				tSystemlogIF.saveSystemlog(searchbean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    */
		/*public static String getSysFlowDefineName(Long id)throws Exception{
			String result = "";
			try {
				if(id!=null){
					FlowDefineIF tFlowDefineIF = DatabaseFactory.getFlowDefineIF();
					FlowDefine tFlowDefine = tFlowDefineIF.searchFlowDefineByID(id);
					if(tFlowDefine!=null)
						result = tFlowDefine.getFlowName();
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return result;
		}*/
		
	    /**
	     * 得到树形结构 部门树
	     * 
	     */
	 /*   public static String getDeptTree() {
		try {

		    String XmlStr = "<script type=\"text/javascript\">	\r<!-- \r d = new dTree('d','../dtree/','testForm');d.add('0','-1',' ');";
		    DeptIF tDeptIF = DatabaseFactory.getDeptIF();
		    List<Dept> list = tDeptIF.getDeptService().getDeptManager().searchListOrderAsc(tDeptIF.createDept());
		    Dept bean = new Dept();
		    if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
			    bean = list.get(i);
			    if (bean.getRemark1().length() == 0) {
				XmlStr += "d.add('" + bean.getId() + "','" + bean.getParentid() + "','" + bean.getRemark1() + " " + bean.getDeptname() + "','../base/dept.do?action=deptlist&id=" + bean.getId() + "','" + bean.getId() + "','aRFrame', '', '', true);";
			    } else {
				XmlStr += "d.add('" + bean.getId() + "','" + bean.getParentid() + "','" + bean.getRemark1() + " " + bean.getDeptname() + "','../base/dept.do?action=deptlist&id=" + bean.getId() + "','" + bean.getId() + "','aRFrame', '', '', false);";
			    }
			}
		    }
		    XmlStr += "document.write(d);";
		    XmlStr += "\r	//-->\r</script>";
		    return XmlStr;
		} catch (Exception exc) {
		    exc.printStackTrace();
		    return "";
		}
	    }
	    */
	    
	    /**
	     * 编码字符传处理加1
	     */
	    public static String method(String code, int len) {// code 要处理的字符窜，
	    	System.out.println("============"+code);
	    	
		// len需要截取的长度
		String result = Long.parseLong(code.substring(code.length() - len, code.length())) + 1 + "";
		if (result.length() < len) {
		    for (int i = 0; i <= len + 1 - result.length(); i++) {
			result = "0" + result;
		    }
		}
		result = code.substring(0, code.length() - len) + result;
		System.out.println("***********************************"+result);
		return result;
	    }
   
	    
	    public static String IsDisabled(String pType,String state) {
		    String returnState = "";
			if (pType != null) {
			    	if(pType.equals(state)){
			    		returnState = "disabled='disabled'";
			    	}
			}
			return returnState;
	    }
	  
	}

