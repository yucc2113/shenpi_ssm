package com.ccgj.controller.matter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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

import com.base.common.util.DateFormat;
import com.base.common.util.GlobalDefine;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.MeetUser;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.beans.Users;
import com.ccgj.database.custom.beans.MeetCustom;
import com.ccgj.service.inter.MeetService;
import com.ccgj.service.inter.MeetUserService;
import com.ccgj.service.inter.UserService;

@Controller
@RequestMapping("meet")
public class MeetController {
	@Autowired 
	private MeetService meetService;
	@Autowired 
	private MeetUserService meetUserService;
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/meetList")
	public String meetList(Model model){
		CommonPage<Meet> commonPage=meetService.searchMeetByNameAndDateWithPage(null, null, null, 1);
		model.addAttribute("commonPage", commonPage);
		return "meet/meetList";
	}

	@RequestMapping("/ajaxMeetList")
	public @ResponseBody
	CommonPage<Meet> ajaxMeetList(HttpServletRequest request, Integer pageNum,
			String searchName, @RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate) {
	
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		CommonPage<Meet> commonPage = meetService
				.searchMeetByNameAndDateWithPage(searchName, startDate,
						endDate, pageNum);
		return commonPage;
	}

	@RequestMapping("/meetAdd")
	public String meetAdd() {
		return "meet/meetAdd";
	}
	@RequestMapping("/meetSave")
	public String meetSave(HttpServletRequest request,Meet meet,MultipartFile file,String usersId) {
		 String oldfilename="";
		 String newfilename="";
		 Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		if(!file.isEmpty()){
			  oldfilename = file.getOriginalFilename();  
			  String type = oldfilename.substring(oldfilename.indexOf("."));// 取文件格式后
			  newfilename = System.currentTimeMillis() + type;
			  
			  String path = request.getSession().getServletContext().getRealPath("/upload");  
			  File targetFile = new File(path, newfilename);  
			  if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		      }  
			  //保存  
		      try {  
		          file.transferTo(targetFile);  
		      } catch (Exception e) {  
		          e.printStackTrace();  
		      }  
		}
		
		
		meet.setOldfilename(oldfilename);
		meet.setNewfilename(newfilename);
		meet.setCreateuser(user.getId());
		meet.setCreatename(user.getUsername());
		meet.setFlag(1);
		meetService.insertMeet(meet);
		
		
		String [] ids = usersId.split(","); 
		for(int i=0;i<ids.length;i++){
			MeetUser meetUser=new MeetUser();
			meetUser.setMeetId(meet.getId());
			meetUser.setCreatedate(meet.getMeetDate());
			meetUser.setFlag(1);
			meetUser.setUserId(Integer.parseInt(ids[i]));
			Users bean=userService.searchUserById(Integer.parseInt(ids[i]));
			meetUser.setUsername(bean.getUsername());
			meetUserService.insertMeetUser(meetUser);
		}
		
	 
	      
		return "forward: meetList";
	}
	@RequestMapping("/meetDetail")
	public String meetDetail(Integer id,Model model, Integer tag) {
		MeetCustom meetCustom=meetUserService.searchMeetCustomByMeetId(id);
		model.addAttribute("meetCustom", meetCustom);
		model.addAttribute("tag", tag);
		return "meet/meetDetail";
	}
	@RequestMapping("/meetUpdate")
	public String meetUpdate(Integer id,Model model) {
		MeetCustom meetCustom=meetUserService.searchMeetCustomByMeetId(id);
		meetCustom.setMeetDateStr(DateFormat.longDate(meetCustom.getMeetDate()));
	    model.addAttribute("id", id);
	    model.addAttribute("meetCustom", meetCustom);
		return "meet/meetAdd";
	}
	
	@RequestMapping("/meetUpdateSave")
	public String meetUpdateSave(HttpServletRequest request,Integer id,Meet meet ,String usersId,MultipartFile file,Model model) {
	    //根据meetID删除原来的meetUser
		meetUserService.deleteMeetUserByMeetId(id);
		
		 
		 Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		if(!file.isEmpty()){
			 String oldfilename="";
			 String newfilename="";
			  oldfilename = file.getOriginalFilename();  
			  String type = oldfilename.substring(oldfilename.indexOf("."));// 取文件格式后
			  newfilename = System.currentTimeMillis() + type;
			  meet.setNewfilename(newfilename);
			  
			  String path = request.getSession().getServletContext().getRealPath("/upload");  
			  File targetFile = new File(path, newfilename);  
			  if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		      }  
			  //保存  
		      try {  
		          file.transferTo(targetFile);  
		      } catch (Exception e) {  
		          e.printStackTrace();  
		      }  
		}
		
		//更新主表
		meetService.updateMeetById(id, meet);
		//更新子表
		String [] ids = usersId.split(","); 
		for(int i=0;i<ids.length;i++){
			MeetUser meetUser=new MeetUser();
			meetUser.setMeetId(meet.getId());
			meetUser.setCreatedate(meet.getMeetDate());
			meetUser.setFlag(1);
			meetUser.setUserId(Integer.parseInt(ids[i]));
			Users bean=userService.searchUserById(Integer.parseInt(ids[i]));
			meetUser.setUsername(bean.getUsername());
			
			meetUserService.insertMeetUser(meetUser);
		}
		
		
		return "forward: meetList";
	}
	@RequestMapping("/meetDelete")
	public String meetDelete(Integer[] ids,Model model) {
		for(int i=0;i<ids.length;i++){
		
				//删除子表信息
				meetUserService.deleteMeetUserByMeetId(ids[i]);
				meetService.deleteMeetById(ids[i]);
			
		}
		
		return "forward: meetList";
	}
	@RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,Integer id,String newfilename) throws IOException {    
        Meet meet=meetService.searchMeetById(id);
    	String path = request.getSession().getServletContext().getRealPath("/upload");  
        File file=new File(path,newfilename);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String(meet.getOldfilename().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);    
    }   
	
    
    @RequestMapping("/myList")
	public String myList(Model model,HttpServletRequest request){
    	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		CommonPage<Meet> commonPage=meetService.searchMeetByNameAndDateAndUserIdWithPage(user.getId(),null, null, null, 1);
		model.addAttribute("commonPage", commonPage);
		return "meet/myMeetList";
	}

	@RequestMapping("/ajaxMyList")
	public @ResponseBody
	CommonPage<Meet> ajaxMyList(HttpServletRequest request, Integer pageNum,
			String searchName, @RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate) {
		Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		CommonPage<Meet> commonPage = meetService
				.searchMeetByNameAndDateAndUserIdWithPage(user.getId(),searchName, startDate,
						endDate, pageNum);
		return commonPage;
	}

    
}
