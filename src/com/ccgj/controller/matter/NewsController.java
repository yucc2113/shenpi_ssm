package com.ccgj.controller.matter;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.util.GlobalDefine;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.database.beans.Users;

import com.ccgj.service.inter.NewsService;

/**
 * 新闻管理
 * @author yucc2113
 *
 */
@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @RequestMapping("/newsList")
    public String newsList(Model model,HttpServletRequest request){
	    CommonPage<News> commonPage=newsService.searchNewsByTitleAndDateListWithPage(null, null, null, 1,null);
		model.addAttribute("commonPage", commonPage);
		return "news/newsList";
	}
    
    @RequestMapping("/ajaxNewsList")
    public @ResponseBody  CommonPage<News> ajaxNewsList(HttpServletRequest request,Integer pageNum,String title,@RequestParam(required=false) Date startDate,@RequestParam(required=false) Date endDate,Integer audit){
    	if(title==null||title.length()<=0) title=null;
    	Integer state=null;
    	if(audit!=null&&audit>0) state=1;
		CommonPage<News> commonPage=newsService.searchNewsByTitleAndDateListWithPage(title, startDate, endDate, pageNum,state);
		return commonPage;
	}
    
    @RequestMapping("/newsAdd")
    public String  newsAdd(Integer id){
		return "news/newsAdd";
	}
    @RequestMapping("/newsSave")
    public String newsSave(HttpServletRequest request ,News news){
    	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
    	news.setCreatename(user.getUsername());
    	news.setCreateuser(user.getId());
    	news.setCreatedate(new Date());
    	news.setLeixing(1);
    	news.setState(1);
    	newsService.insertNews(news);
    	return "forward: newsList";
    }
    @RequestMapping("/newsUpdate")
    public String  newsUpdate(Integer id,Model model){
    	model.addAttribute("id", id);
    	News news=newsService.searchNewsById(id);
    	model.addAttribute("news", news);
		return "news/newsAdd";
	}
    @RequestMapping("/newsUpdateSave")
    public String newsUpdateSave(HttpServletRequest request ,Integer id,String title,String content){
    	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
    	News news=newsService.searchNewsById(id);
    	news.setTitle(title);
    	news.setContent(content);
    	newsService.updateNewsById(news.getId(), news);
    	return "forward: newsList";
    }
    @RequestMapping("/newsDelete")
    public String newsDelete(Integer[] ids){
    	for(int i=0;i<ids.length;i++){
			int id=ids[i];
			newsService.deleteNewsById(id);
		}
    	return "forward: newsList";
    }
    
    @RequestMapping("/newsDetail")
    public String  newsDetail(Integer id,Model model,Integer flag){
    	
    	News news=newsService.searchNewsById(id);
    	model.addAttribute("news", news);
    	model.addAttribute("flag", flag);
		return "news/newsDetail";
	}
    /**
     * 新闻审批列表
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/auditList")
    public String  auditList(Integer id,Model model){
    	
    	 CommonPage<News> commonPage=newsService.searchNewsByTitleAndDateListWithPage(null, null, null, 1,1);
  		model.addAttribute("commonPage", commonPage);
  		return "news/auditList";
	} 
    /**
     * 审批页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/auditDetail")
    public String  auditDetail(Integer id,Model model){
    	News news=newsService.searchNewsById(id);
    	model.addAttribute("news", news);
		return "news/auditDetail";
	} 
    @RequestMapping("/auditSave")
    public String  auditSave(HttpServletRequest request,Integer audit,Integer id,Model model){
    	Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
    	News news=newsService.searchNewsById(id);
    	news.setApprovedate(new Date());
    	news.setApproveuser(user.getId());
    	news.setState(audit);
    	newsService.updateNewsById(news.getId(), news);
		return "forward: auditList";
	} 
    
    
    @RequestMapping("/myList")
    public String myList(Model model,HttpServletRequest request){
    	//审批通过的新闻
	    CommonPage<News> commonPage=newsService.searchNewsByTitleAndDateListWithPage(null, null, null, 1,2);
		model.addAttribute("commonPage", commonPage);
		return "news/myNewsList";
	}
    
    @RequestMapping("/ajaxMyList")
    public @ResponseBody  CommonPage<News> ajaxMyList(HttpServletRequest request,Integer pageNum,String title,@RequestParam(required=false) Date startDate,@RequestParam(required=false) Date endDate,Integer audit){
    	if(title==null||title.length()<=0) title=null;
		CommonPage<News> commonPage=newsService.searchNewsByTitleAndDateListWithPage(title, startDate, endDate, pageNum,2);
		return commonPage;
	}
    
}
