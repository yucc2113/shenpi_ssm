package com.ccgj.controller.systemlog;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.service.inter.SystemlogService;

@Controller
@RequestMapping("/systemlog")
public class SystemLogController {
	@Autowired 
	private SystemlogService systemlogService;
	@RequestMapping("/logList")
     public String logList(Model model,HttpServletRequest request){
	    CommonPage<Systemlog> commonPage=systemlogService.searchSystemlogListByNameAndDateByPage(null, null, null, 1);
		model.addAttribute("commonPage", commonPage);
		return "systemlog/systemLogList";
	}
	@RequestMapping("/ajaxLogList")
     public @ResponseBody CommonPage<Systemlog> ajaxLogList(HttpServletRequest request,Integer pageNum,String searchName,@RequestParam(required=false) Date startDate,@RequestParam(required=false) Date endDate){
		if(searchName==null||searchName.length()<=0) searchName=null;
		CommonPage<Systemlog> commonPage=systemlogService.searchSystemlogListByNameAndDateByPage(searchName, startDate, endDate, pageNum);
		return commonPage;
	}
}
