package com.ccgj.controller.matter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.util.GlobalDefine;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Notice;
import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.beans.Users;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.service.inter.NoticeService;
import com.ccgj.service.inter.NoticeUserService;
import com.ccgj.service.inter.UserService;


@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeUserService noticeUserService;
	@Autowired
	private UserService userService;
    /**
     * 查询出通知列表(此处的usersId是真正的，并未进行编码)
     * @param model
     * @param request
     * @return
     */
	@RequestMapping("/noticeList")
	public String noticeList(Model model, HttpServletRequest request) {
		CommonPage<NoticeCustom> commonPage = noticeService
				.searchNewsByTitleAndDateListWithPage(null, null, null, 1);
		List<NoticeCustom> dataList=new ArrayList<NoticeCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			NoticeCustom bean=commonPage.getDataList().get(i);
			List<NoticeUser> list=noticeUserService.searchByNoticeId(bean.getId());
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
		return "notice/noticeList";
	}
	/**
	 * 查询出通知列表(此处的usersId是真正的，并未进行编码)
	 * @param request
	 * @param pageNum
	 * @param searchName
	 * @param startDate
	 * @param endDate
	 * @return
	 */

	@RequestMapping("/ajaxNoticeList")
	public @ResponseBody
	CommonPage<NoticeCustom> ajaxNoticeList(HttpServletRequest request,
			Integer pageNum, String searchName,
			@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate) {
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		CommonPage<NoticeCustom> commonPage = noticeService
				.searchNewsByTitleAndDateListWithPage(searchName, startDate,
						endDate, pageNum);
		List<NoticeCustom> dataList=new ArrayList<NoticeCustom>();
		
		for(int i=0;i<commonPage.getDataList().size();i++){
			NoticeCustom bean=commonPage.getDataList().get(i);
			List<NoticeUser> list=noticeUserService.searchByNoticeId(bean.getId());
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
			bean.setNum(list.size());
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		return commonPage;
	}
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("/noticeAdd")
    public String  noticeAdd(){
		return "notice/noticeAdd";
	}
	
	/**
	 * 新增保存
	 * @param request
	 * @param notice
	 * @param usersId：页面传来的参数，(usersId是未经编码的，由于该值在前台已经转换成功)
	 * @return
	 */
	@RequestMapping("/noticeSave")
    public String  noticeSave(HttpServletRequest request,Notice notice,String usersId){
		Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		notice.setCreateuser(user.getId());
		notice.setCreatename(user.getUsername());
		notice.setCreatedate(new Date());
		notice.setState(1);
		noticeService.insertNotice(notice);
		
		
		String [] ids = usersId.split(",");
		
		for(int i=0;i<ids.length;i++){
			NoticeUser noticeUser=new NoticeUser();
			noticeUser.setNoticeId(notice.getId());
			noticeUser.setCreatedate(notice.getCreatedate());
			noticeUser.setFlag(1);
			noticeUser.setUserId(Integer.parseInt(ids[i]));
			Users bean=userService.searchUserById(Integer.parseInt(ids[i]));
			noticeUser.setUsername(bean.getUsername());
			noticeUserService.insertNoticeUser(noticeUser);
		}
		
		return "forward: noticeList";
	}
	/**
	 * 查看一个通知的详情
	 * @param id：页面传来的通知的ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/noticeDetail")
	public String noticeDetail(Integer id,Model model,Integer flag){
		NoticeCustom noticeCustom=noticeUserService.searchNoticeCustomById(id);
		model.addAttribute("noticeCustom", noticeCustom);
		model.addAttribute("flag", flag);
		return "notice/noticeDetail";
	}
	/**
	 * 跳转到更新页面，并把通知信息带到前台
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/noticeUpdate")
    public String  noticeUpdate(Integer id,Model model){
		NoticeCustom noticeCustom=noticeUserService.searchNoticeCustomById(id);
		model.addAttribute("noticeCustom", noticeCustom);
	    model.addAttribute("id", id);
		return "notice/noticeAdd";
	}
	/**
	 * 更新保存(usersId是未经编码的，由于该值在前台已经转换成功)
	 * @param id
	 * @param noticeCustom
	 * @return
	 */
	@RequestMapping("/noticeUpdateSave")
    public String  noticeUpdateSave(Integer id,NoticeCustom noticeCustom){
		//删除原来的子表
		List<NoticeUser> list=noticeUserService.searchByNoticeId(id);
		for(int i=0;i<list.size();i++){
			noticeUserService.deleteNoticeUserById(list.get(i).getId());
		}
		//更改主表
		Notice notice=noticeService.searchNoticeById(id);
		notice.setTitle(noticeCustom.getTitle());
		notice.setContent(noticeCustom.getContent());
		noticeService.updateNoticeById(id, notice);
		
		//重新创建对应的子表
		String usersId=noticeCustom.getUsersId();
		String [] ids = usersId.split(",");
		System.out.println("====================="+usersId);
		for(int i=0;i<ids.length;i++){
			NoticeUser noticeUser=new NoticeUser();
			noticeUser.setNoticeId(notice.getId());
			noticeUser.setCreatedate(notice.getCreatedate());
			noticeUser.setFlag(1);
			noticeUser.setUserId(Integer.parseInt(ids[i]));
			Users bean=userService.searchUserById(Integer.parseInt(ids[i]));
			noticeUser.setUsername(bean.getUsername());
			noticeUserService.insertNoticeUser(noticeUser);
		}
		return "forward:noticeList";
	}
	@RequestMapping("/noticeDelete")
	public String noticeDelete(Integer[] ids){
		
		for(int i=0;i<ids.length;i++){
			//删除子表信息
			noticeUserService.deleteNoticeUserByNoticeId(ids[i]);
			noticeService.deleteNoticeById(ids[i]);
		}
		return "forward:noticeList";
	}
	/**
	 * 我的通知
	 * @param ids
	 * @return
	 */
	@RequestMapping("/myList")
	public String myList(HttpServletRequest request,String searchName,
			@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate,Model model){
		Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
		CommonPage<NoticeCustom> commonPage = noticeService
				.searchNewsByTitleAndDateAndUserIdWithPage(user.getId(),null, null, null, 1);
		List<NoticeCustom> dataList=new ArrayList<NoticeCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			NoticeCustom bean=commonPage.getDataList().get(i);
			List<NoticeUser> list=noticeUserService.searchByNoticeId(bean.getId());
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
		model.addAttribute("flag", "myList");
		return "notice/myNoticeList";
	}
	@RequestMapping("/ajaxMyList")
	public @ResponseBody
	CommonPage<NoticeCustom> ajaxMyList(HttpServletRequest request,
			Integer pageNum, String searchName,
			@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate) {
		Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		CommonPage<NoticeCustom> commonPage = noticeService
				.searchNewsByTitleAndDateAndUserIdWithPage(user.getId(),searchName, startDate,
						endDate, pageNum);
		List<NoticeCustom> dataList=new ArrayList<NoticeCustom>();
		
		for(int i=0;i<commonPage.getDataList().size();i++){
			NoticeCustom bean=commonPage.getDataList().get(i);
			List<NoticeUser> list=noticeUserService.searchByNoticeId(bean.getId());
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
			bean.setNum(list.size());
			dataList.add(bean);
		}
		commonPage.setDataList(dataList);
		return commonPage;
	}
}
