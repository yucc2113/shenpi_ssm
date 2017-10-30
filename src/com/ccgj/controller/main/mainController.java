package com.ccgj.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.common.util.GlobalDefine;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.FlowDefine;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.UflowBiaodan;
import com.ccgj.database.beans.Users;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.service.inter.FlowDefineService;
import com.ccgj.service.inter.MeetService;
import com.ccgj.service.inter.NewsService;
import com.ccgj.service.inter.NoticeService;
import com.ccgj.service.inter.UFlowBiaodanService;

@Controller
@RequestMapping("main")
public class mainController {
	@Autowired
	private FlowDefineService flowDefineService;
	@Autowired
	private UFlowBiaodanService uflowBiaodanService;
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private MeetService meetService;
	
	@RequestMapping("/init")
    public String init(HttpServletRequest request,Model model){
    	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
    	FlowDefine bean =  new FlowDefine();
		//我的流程
		List<FlowDefine> flowList = flowDefineService.searchByIsEnabled(1);
		model.addAttribute("flowList", flowList);
		//我的任务
		
		List<UflowBiaodan> auditList=uflowBiaodanService.searchByUser(user);
		model.addAttribute("auditList", auditList);
		//我的新闻		
		CommonPage<News> newsCommonPage=newsService.searchNewsByTitleAndDateListWithPage(null, null, null, 1, 2);
		model.addAttribute("newsCommonPage", newsCommonPage);
		//我的通知
		CommonPage<NoticeCustom> noticeCommonPage=noticeService.searchNewsByTitleAndDateAndUserIdWithPage(user.getId(), null, null, null, 1);
		model.addAttribute("noticeCommonPage", noticeCommonPage);
		//我的会议
		CommonPage<Meet> meetCommonPage=meetService.searchMeetByNameAndDateAndUserIdWithPage(user.getId(), null, null, null, 1);
		model.addAttribute("meetCommonPage", meetCommonPage);
    	return "main";
    }
}
