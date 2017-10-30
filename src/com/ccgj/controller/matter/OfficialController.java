package com.ccgj.controller.matter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.base.common.util.GlobalDefine;
import com.base.common.util.SystemUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.MeetUser;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.beans.Official;
import com.ccgj.database.beans.OfficialUser;
import com.ccgj.database.beans.Officialset;
import com.ccgj.database.beans.Users;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.database.custom.beans.OfficialCustom;
import com.ccgj.service.inter.OfficialService;
import com.ccgj.service.inter.OfficialUserService;
import com.ccgj.service.inter.OfficialsetService;
import com.ccgj.service.inter.UserService;

@Controller
@RequestMapping("official")
public class OfficialController {
   @Autowired
   private OfficialsetService officialsetService;
   @Autowired
   private OfficialService officialService;
   @Autowired
   private OfficialUserService officialUserService;
   @Autowired
   private UserService userService;
   
   /**
    * 跳转到文号设定页面
    * @param model
    * @return
    */
   @RequestMapping("/officialSet")
   public String officialSet(Model model){
	   List<Officialset> list=officialsetService.searchOfficialsetList();
	   Officialset officialset=list.get(0);
	   model.addAttribute("officialset", officialset);
	   return "official/officialSet";
   }
   /**
    * 文号设定保存
    * @param model
    * @param officialset
    * @return
    */
   @RequestMapping("/toSaveSet")
   public String toSaveSet(Model model,Officialset officialset){
	   List<Officialset> list=officialsetService.searchOfficialsetList();
	   if(null != list && list.size()>0){
			Officialset searchbean = (Officialset)list.get(0);
			searchbean.setName(officialset.getName());
			searchbean.setType(1);
			officialsetService.updateOfficialsetById(searchbean.getId(),searchbean);
		}else{
		
			officialset.setType(1);
			officialsetService.insertOfficialset(officialset);
		}
	   model.addAttribute("officialset", officialset);
	   return "official/officialSet";
   }
   /**
    * 显示公文列表
    * @param model
    * @return
    */
   @RequestMapping("/officialList")
   public String officialList(Model model){
	   
		CommonPage<OfficialCustom> commonPage = officialService.searchListByNameAndDateWithPage(null, null, null, 1,null);
		
		
		
		List<OfficialCustom> dataList=new ArrayList<OfficialCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			OfficialCustom bean=commonPage.getDataList().get(i);
			List<OfficialUser> list=officialUserService.searchListByZhuId(bean.getId());
	        String usersname="";
	        String usersId="";
			if(list!=null&&list.size()>0){
	        	for(int j=0;j<list.size()-1;j++){
	        		usersname+=(list.get(j).getUsername()+",");
	        		usersId+=(list.get(j).getUserId()+",");
	        	}
	        	usersname+=list.get(list.size()-1).getUsername();
	        	usersId+=list.get(list.size()-1).getUserId();
	        }
			bean.setUsersId(usersId);
			bean.setUsersName(usersname);
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		model.addAttribute("commonPage", commonPage);

		return "official/officialList";
   }
   /**
    * 动态刷新页面
    * @param request
    * @param pageNum :当前页数
    * @param searchName:查询的公文名称
    * @param startDate:开始日期
    * @param endDate:结束日期
    * @return
    */
	@RequestMapping("/ajaxOfficialList")
	public @ResponseBody
	CommonPage<OfficialCustom> ajaxOfficialList(HttpServletRequest request, Integer pageNum,
			String searchName, @RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate,Integer audit) {
	
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		Integer state=null;
    	if(audit!=null&&audit>0) state=1;
    	
		CommonPage<OfficialCustom> commonPage = officialService.searchListByNameAndDateWithPage(searchName, startDate,
						endDate, pageNum,state);
		
		List<OfficialCustom> dataList=new ArrayList<OfficialCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			OfficialCustom bean=commonPage.getDataList().get(i);
			List<OfficialUser> list=officialUserService.searchListByZhuId(bean.getId());
	        String usersname="";
	        String usersId="";
			if(list!=null&&list.size()>0){
	        	for(int j=0;j<list.size()-1;j++){
	        		usersname+=(list.get(j).getUsername()+",");
	        		usersId+=(list.get(j).getUserId()+",");
	        	}
	        	usersname+=list.get(list.size()-1).getUsername();
	        	usersId+=list.get(list.size()-1).getUserId();
	        }
			bean.setUsersId(usersId);
			bean.setUsersName(usersname);
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		return commonPage;
	}
   /**
    * 跳转到公文新增页面
    * @param model
    * @return
    */
   @RequestMapping("/officialAdd")
   public String officialAdd(Model model){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	   String year = sdf.format(new Date());
	   
	   //公文文号设定列表
	   List list= officialsetService.searchOfficialsetList();
	   String wenhao="";
	   if(null != list && list.size()>0){
			Officialset searchset = (Officialset)list.get(0);
			String wenhao1 = searchset.getName()+"【"+year+"】";
			List<Official> searchlist = officialService.searchByWenhao(wenhao1);
			if(null != searchlist && searchlist.size()>0){
				String wenhao2 = SystemUtil.method(searchlist.get(searchlist.size()-1).getWenhao().split("】")[1].split("号")[0], 4);
				wenhao = searchset.getName()+"【"+year+"】"+wenhao2+"号";
			}else{
				wenhao = searchset.getName()+"【"+year+"】0001号";
			}
		    model.addAttribute("wenhao", wenhao);	
		}
	   return "official/officialAdd";
   }
   /**
    * 公文保存
    * @param model
    * @return
    */
   @RequestMapping("/save")
	public String save(String wenhao, MultipartFile file,HttpServletRequest request,String usersId) {
		String oldfilename = "";
		String newfilename = "";
		
		Official official=new Official();
		Users user = (Users) request.getSession().getAttribute(
				GlobalDefine.USER);
		if (!file.isEmpty()) {
			oldfilename = file.getOriginalFilename();
			String type = oldfilename.substring(oldfilename.indexOf("."));// 取文件格式后
			newfilename = System.currentTimeMillis() + type;

			String path = request.getSession().getServletContext().getRealPath("/upload/official");
			File targetFile = new File(path, newfilename);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			official.setFilename(oldfilename);//公文名称即文件名
			official.setFilenamedisk(newfilename);//编码后的文件名
			official.setWenhao(wenhao);//公文文号
			official.setCreateuser(user.getId());//公文创建人ID
			official.setCreatename(user.getUsername());//公文创建人姓名
			official.setCreatedate(new Date());//公文创建日期
			official.setState(1);//公文状态(1:待处理;2:审核通过;3:审核未通过)
		}
		officialService.insertOfficial(official);

		String [] ids = usersId.split(","); 
	
		for(int i=0;i<ids.length;i++){
				OfficialUser officialUser=new OfficialUser();
				officialUser.setOfficialId(official.getId());
				officialUser.setUserId(Integer.parseInt(ids[i]));
				officialUser.setCreatedate(official.getCreatedate());
				officialUser.setFlag(1);
			
				Users bean=userService.searchUserById(Integer.parseInt(ids[i]));
				officialUser.setUsername(bean.getUsername());
			   
				officialUserService.insert(officialUser);
			}
		
		return "forward:officialList";
	}
   @RequestMapping("/update")
   public String update(Model model,Integer id){
	  
	   Official official=officialService.searchById(id);
	   model.addAttribute("official", official);
	   
	   String usersName="";
	   String usersId="";
	   List<OfficialUser> list=officialUserService.searchListByZhuId(id);
	   if(list!=null&&list.size()>0){
		   for(int i=0;i<list.size()-1;i++){
			   usersName+=(list.get(i).getUsername()+",");
	       	   usersId+=(list.get(i).getUserId()+",");
	        }
		    usersName+=list.get(list.size()-1).getUsername();
	        usersId+=list.get(list.size()-1).getUserId();
	   }
	   
	   model.addAttribute("id", id);
	   model.addAttribute("wenhao",official.getWenhao());
	   model.addAttribute("usersName", usersName);
	   model.addAttribute("usersId", usersId);
	   
	   return "official/officialAdd";
   }
   
   /**
    * 修改保存
    * @param official
    * @param file
    * @param request
    * @param usersId
    * @return
    */
   @RequestMapping("/updateSave")
  	public String updateSave(Official official, MultipartFile file,HttpServletRequest request,String usersId) {
  		String oldfilename = "";
  		String newfilename = "";
  		
  		Official bean=officialService.searchById(official.getId());
  		
  		Users user = (Users) request.getSession().getAttribute(
  				GlobalDefine.USER);
  		if (!file.isEmpty()) {
  			oldfilename = file.getOriginalFilename();
  			String type = oldfilename.substring(oldfilename.indexOf("."));// 取文件格式后
  			newfilename = System.currentTimeMillis() + type;

  			String path = request.getSession().getServletContext().getRealPath("/upload/official");
  			File targetFile = new File(path, newfilename);
  			if (!targetFile.exists()) {
  				targetFile.mkdirs();
  			}
  			// 保存
  			try {
  				file.transferTo(targetFile);
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  			bean.setFilename(oldfilename);//公文名称即文件名
  			bean.setFilenamedisk(newfilename);//编码后的文件名
  		}
  		bean.setCreateuser(user.getId());//公文创建人ID
		bean.setCreatename(user.getUsername());//公文创建人姓名
		bean.setCreatedate(new Date());//公文创建日期
		bean.setState(1);//公文状态(1:待处理;2:审核通过;3:审核未通过)
  		officialService.updateOfficial(official);
   
  		//删除子表相关数据
  		officialUserService.deleteByZhuId(official.getId());
  		
  		String [] ids = usersId.split(","); 
  	
  		for(int i=0;i<ids.length;i++){
  				OfficialUser officialUser=new OfficialUser();
  				officialUser.setOfficialId(official.getId());
  				officialUser.setUserId(Integer.parseInt(ids[i]));
  				officialUser.setCreatedate(official.getCreatedate());
  				officialUser.setFlag(1);
  			
  				Users temp=userService.searchUserById(Integer.parseInt(ids[i]));
  				officialUser.setUsername(temp.getUsername());
  			   
  				officialUserService.insert(officialUser);
  			}
  		
  		return "forward:officialList";
  	}
   
   /**
    * 删除公文
    * @param ids
    * @return
    */
   @RequestMapping("/delete")
  	public String delete(Integer[] ids) {
	   
		for(int i=0;i<ids.length;i++){
			//删除子表信息
			officialUserService.deleteByZhuId(ids[i]);
			officialService.deleteById(ids[i]);
		}
  		
  		return "forward:officialList";
  	}
   /**
    * 查看公文详情
    * @param ids
    * @return
    */
   @RequestMapping("/detail")
 	public String detail(Integer id,Model model,Integer tag) {
	   
	   Official official=officialService.searchById(id);
	   model.addAttribute("official", official);
	   
	   String usersName="";
	   String usersId="";
	   List<OfficialUser> list=officialUserService.searchListByZhuId(id);
	   if(list!=null&&list.size()>0){
		   for(int i=0;i<list.size()-1;i++){
			   usersName+=(list.get(i).getUsername()+",");
	       	   usersId+=(list.get(i).getUserId()+",");
	        }
		    usersName+=list.get(list.size()-1).getUsername();
	        usersId+=list.get(list.size()-1).getUserId();
	   }
	   
	   model.addAttribute("id", id);
	   model.addAttribute("wenhao",official.getWenhao());
	   model.addAttribute("usersName", usersName);
	   model.addAttribute("usersId", usersId);
    	model.addAttribute("tag", tag);

 		return "official/officialDetail";
 	}
   /**
    * 下载公文文件
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,HttpServletResponse response,Integer id,String newfilename) throws IOException{
		    Official  official=officialService.searchById(id);
	    	String path = request.getSession().getServletContext().getRealPath("/upload/official");  
	        File file=new File(path,newfilename);  
	        if (file.exists()) {
	        	HttpHeaders headers = new HttpHeaders();    
	 	        String fileName=new String(official.getFilename().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	 	        headers.setContentDispositionFormData("attachment", fileName);   
	 	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	 	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	 	                                          headers, HttpStatus.CREATED);    
	        }
	        else {
	        	response.setCharacterEncoding("utf-8");
	        	PrintWriter out = response.getWriter();   
                out.print("<script>");   
                out.print("alert(\"文件不存在\")");   
                out.print("</script>");   
                return null;
	        }
	       
	}
  
   
   
   
   /**
    * 保存人员
    * @param model
    * @return
    */
   @RequestMapping(value="/selectUser",produces={"text/html;charset=UTF-8;","application/json;"})
   public @ResponseBody String selectUser(Integer id,String usersId,Model model,HttpServletResponse response){
	   response.setCharacterEncoding("utf-8");
	 
	   
	   Official official=officialService.searchById(id);
	   
	   String [] ids = usersId.split(","); 
	   
	   String usersName="";
		for(int i=0;i<ids.length;i++){
			OfficialUser officialUser=new OfficialUser();
			officialUser.setOfficialId(id);
			officialUser.setUserId(Integer.parseInt(ids[i]));
			officialUser.setCreatedate(official.getCreatedate());
			officialUser.setFlag(1);
			System.out.println("======="+ids[i]);
			Users bean=userService.searchUserById(Integer.parseInt(ids[i]));
			officialUser.setUsername(bean.getUsername());
		    if(i<ids.length-1){
        		usersName+=bean.getUsername()+",";	
        	}
		    else usersName+=bean.getUsername();
			
			officialUserService.insert(officialUser);
		}
	    model.addAttribute("usersName", usersName);
	
	   return usersName;
   }
   
   /**
    * 审批列表
    * @param model
    * @return
    */
  
   @RequestMapping("/auditList")
   public String auditList(Model model){
	   System.out.println("hi");
	   CommonPage<OfficialCustom> commonPage=officialService.searchListByNameAndDateWithPage(null, null, null, 1,1);
	   List<OfficialCustom> dataList=new ArrayList<OfficialCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			OfficialCustom bean=commonPage.getDataList().get(i);
			List<OfficialUser> list=officialUserService.searchListByZhuId(bean.getId());
	        String usersname="";
	        String usersId="";
			if(list!=null&&list.size()>0){
	        	for(int j=0;j<list.size()-1;j++){
	        		usersname+=(list.get(j).getUsername()+",");
	        		usersId+=(list.get(j).getUserId()+",");
	        	}
	        	usersname+=list.get(list.size()-1).getUsername();
	        	usersId+=list.get(list.size()-1).getUserId();
	        }
			bean.setUsersId(usersId);
			bean.setUsersName(usersname);
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		model.addAttribute("commonPage", commonPage);
	   return "official/officialAuditList";
   }
   @RequestMapping("/auditDetail")
   public String  auditDetail(Integer id,Model model){
   	Official official=officialService.searchById(id);
   	model.addAttribute("official", official);
   	
   	String usersName="";
	   String usersId="";
	   List<OfficialUser> list=officialUserService.searchListByZhuId(id);
	   if(list!=null&&list.size()>0){
		   for(int i=0;i<list.size()-1;i++){
			   usersName+=(list.get(i).getUsername()+",");
	       	   usersId+=(list.get(i).getUserId()+",");
	        }
		    usersName+=list.get(list.size()-1).getUsername();
	        usersId+=list.get(list.size()-1).getUserId();
	   }
	   
	   model.addAttribute("id", id);
	   model.addAttribute("wenhao",official.getWenhao());
	   model.addAttribute("usersName", usersName);
	   model.addAttribute("usersId", usersId);
		return "official/officialAuditDetail";
	} 
   
   @RequestMapping("/auditSave")
   public String  auditSave(HttpServletRequest request,Integer audit,Integer id,Model model){
   	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
   	Official official=officialService.searchById(id);
   	official.setApprovedate(new Date());
   	official.setApproveuser(user.getId());
   	official.setState(audit);
   	officialService.updateOfficial(official);
		return "forward: auditList";
	} 
   
   
   @RequestMapping("/myList")
   public String myList(HttpServletRequest request,Model model){
	   Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		CommonPage<OfficialCustom> commonPage = officialService.searchListByNameAndDateAndUserIdWithPage(user.getId(),null, null, null, 1,null);
		
		
		
		List<OfficialCustom> dataList=new ArrayList<OfficialCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			OfficialCustom bean=commonPage.getDataList().get(i);
			List<OfficialUser> list=officialUserService.searchListByZhuId(bean.getId());
	        String usersname="";
	        String usersId="";
			if(list!=null&&list.size()>0){
	        	for(int j=0;j<list.size()-1;j++){
	        		usersname+=(list.get(j).getUsername()+",");
	        		usersId+=(list.get(j).getUserId()+",");
	        	}
	        	usersname+=list.get(list.size()-1).getUsername();
	        	usersId+=list.get(list.size()-1).getUserId();
	        }
			bean.setUsersId(usersId);
			bean.setUsersName(usersname);
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		model.addAttribute("commonPage", commonPage);
      
		return "official/myOfficialList";
   }
   /**
    * 动态刷新页面
    * @param request
    * @param pageNum :当前页数
    * @param searchName:查询的公文名称
    * @param startDate:开始日期
    * @param endDate:结束日期
    * @return
    */
	@RequestMapping("/ajaxMyList")
	public @ResponseBody
	CommonPage<OfficialCustom> ajaxMyList(HttpServletRequest request, Integer pageNum,
			String searchName, @RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate,Integer audit) {
		 Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		Integer state=null;
    	if(audit!=null&&audit>0) state=1;
    	
		CommonPage<OfficialCustom> commonPage = officialService.searchListByNameAndDateAndUserIdWithPage(user.getId(),searchName, startDate,
						endDate, pageNum,state);
		
		List<OfficialCustom> dataList=new ArrayList<OfficialCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			OfficialCustom bean=commonPage.getDataList().get(i);
			List<OfficialUser> list=officialUserService.searchListByZhuId(bean.getId());
	        String usersname="";
	        String usersId="";
			if(list!=null&&list.size()>0){
	        	for(int j=0;j<list.size()-1;j++){
	        		usersname+=(list.get(j).getUsername()+",");
	        		usersId+=(list.get(j).getUserId()+",");
	        	}
	        	usersname+=list.get(list.size()-1).getUsername();
	        	usersId+=list.get(list.size()-1).getUserId();
	        }
			bean.setUsersId(usersId);
			bean.setUsersName(usersname);
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		return commonPage;
	}
   
}
