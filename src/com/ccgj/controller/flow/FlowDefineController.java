package com.ccgj.controller.flow;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.FlowDefine;

import com.ccgj.service.inter.FlowDefineService;
import com.ccgj.service.inter.UdefineBiaodanService;

@Controller
@RequestMapping("flowdefine")
public class FlowDefineController {
	@Autowired
	private FlowDefineService flowDefineService;
	@Autowired
	private UdefineBiaodanService udBiaodanService;
	@RequestMapping("/list")
	public String list(Model model) {
		  CommonPage<FlowDefine> commonPage=flowDefineService.searchByNameAndStateWithPage(null, null,null);
			model.addAttribute("commonPage", commonPage);
		return "flow/flowDefineList";   
  	}
	@RequestMapping("/ajaxList")

    public @ResponseBody  CommonPage<FlowDefine> ajaxList(HttpServletRequest request,Integer pageNum,String searchName,Integer isEnabled){
    	if(searchName==null||searchName.length()<=0) searchName=null;
		CommonPage<FlowDefine> commonPage=flowDefineService.searchByNameAndStateWithPage(searchName, isEnabled, pageNum);
		return commonPage;
	}
	/**
	 * 跳转到定义流程的添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		 
		return "flow/flowDefineAdd";   
  	}
	@RequestMapping("/save")
	public String save(FlowDefine bean,Model model) {
		 
		flowDefineService.insert(bean);
		return "forward:list";   
  	}
	@RequestMapping("/update")
	public String update(Integer id,Model model) {
		FlowDefine  flowDefine=flowDefineService.searchById(id);
		model.addAttribute("flowDefine", flowDefine);
		model.addAttribute("id", id);
		return "flow/flowDefineAdd";   
  	}
	@RequestMapping("/updateSave")
	public String updateSave(Integer id,FlowDefine bean,Model model) {
	    flowDefineService.updateById(id, bean);
		return "forward:list";   
  	}
	@RequestMapping("/detail")
	public String detail(Integer id,Model model) {
		FlowDefine  flowDefine=flowDefineService.searchById(id);
		model.addAttribute("flowDefine", flowDefine);
		
		return "flow/flowDefineDetail";   
  	}
	
	/**
	 * 跳转到选择表单的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/addBiaodan")
	public String addBiaodan(Integer id,Model model) {
		List biaodanList=udBiaodanService.searchAllList();
		FlowDefine flow=flowDefineService.searchById(id);
		model.addAttribute("flow", flow);
		model.addAttribute("biaodanList", biaodanList);
		model.addAttribute("id", id);
		
		return "flow/biaodanAdd";   
  	}
	@RequestMapping("/biaodanAddSave")
	public String biaodanAddSave(Integer id,Integer biaodanId,Model model) {
		FlowDefine bean=new FlowDefine();
		bean.setBiaodanId(biaodanId);
		flowDefineService.updateById(id, bean);
		return "forward:list";   
  	}
	
	@RequestMapping("/myList")
	public String myList(Model model) {
		  List list=flowDefineService.searchByIsEnabled(1);
		  
			model.addAttribute("dataList", list);
		return "biaodan/myflow";   
  	}

	
}
