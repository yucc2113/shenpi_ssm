package com.ccgj.controller.flow;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.util.GlobalDefine;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.FlowDefine;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.UdefineBiaodan;
import com.ccgj.database.beans.Users;
import com.ccgj.service.inter.FlowDefineService;
import com.ccgj.service.inter.UdefineBiaodanService;



@Controller
@RequestMapping("udefineBiaodan")
public class UdefineBiaodanController {
	@Autowired 
	private UdefineBiaodanService uDefineBiaodanService;
	@Autowired
	private FlowDefineService flowDefineService;
    /**
     * 显示表单列表
     * @param model
     * @return
     */
	@RequestMapping("/biaodanList")
	public String biaodanList(Model model){
		  CommonPage<UdefineBiaodan> commonPage=uDefineBiaodanService.searchByNameAndDateListWithPage(null, null, null, 1,null);
			model.addAttribute("commonPage", commonPage);
		return "udefine/biaodanList";
	}
	@RequestMapping("/ajaxBiaodanList")

    public @ResponseBody  CommonPage<UdefineBiaodan> ajaxBiaodanList(HttpServletRequest request,Integer pageNum,String searchName,@RequestParam(required=false) Date startDate,@RequestParam(required=false) Date endDate,Integer audit){
    	if(searchName==null||searchName.length()<=0) searchName=null;
    	Integer state=null;
    	if(audit!=null&&audit>0) state=1;
		CommonPage<UdefineBiaodan> commonPage=uDefineBiaodanService.searchByNameAndDateListWithPage(searchName, startDate, endDate,pageNum,null);
		return commonPage;
	}
	/**
	 * 跳转到新建表单页面
	 * @return
	 */
	 @RequestMapping("/biaodanAdd")
	 public String biaodanAdd(){
       return "udefine/biaodanAdd";
	 }
	 /**
	  * 保存新建的表单
	  * @param request
	  * @param mingchen
	  * @return
	  */
	 @RequestMapping("/biaodanSave")
	 public String biaodanSave(HttpServletRequest request,String mingchen){
		 Users user=(Users) request.getSession().getAttribute(GlobalDefine.USER);
		
		 UdefineBiaodan bean=new UdefineBiaodan();
		 bean.setMingchen(mingchen);
		 bean.setCreateuser(user.getId());
		 bean.setCreatename(user.getUsername());
		 bean.setCreatedate(new Date());
		 bean.setState(1);
		
		 uDefineBiaodanService.insertUdefineBiaodan(bean);
	     return "forward:biaodanList";
	 }
	 /**
	  * 跳转到更新表单页面
	  * @param id
	  * @param model
	  * @return
	  */
	 @RequestMapping("/biaodanUpdate")
	 public String biaodanUpdate(Integer id,Model model){
		
		 UdefineBiaodan biaodan=uDefineBiaodanService.searchById(id);
		 model.addAttribute("id", id);
		 model.addAttribute("biaodan", biaodan);
       return "udefine/biaodanAdd";
	 }
	 /**
	  * 保存表单的更新信息
	  * @param id
	  * @param biaodan
	  * @return
	  */
	 @RequestMapping("/biaodanUpdatetSave")
	 public String biaodanUpdatetSave(Integer id,UdefineBiaodan biaodan){
		
				
		 uDefineBiaodanService.updateById(id, biaodan);
	     return "forward:biaodanList";
	 }
    /**
     * 删除表单
     * @param ids
     * @return
     */
	@RequestMapping("/delete")
	public String delete(Integer[] ids) {

		for (int i = 0; i < ids.length; i++) {
			// 删除子表信息
			uDefineBiaodanService.deleteById(ids[i]);
			
		}

		return "forward:biaodanList";
	}
	/**
	 * 跳转到为表单添加流程的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/addFlow")
	public String addFlow(Integer id,Model model) {
       
		//根据ID查询表单信息
		UdefineBiaodan bean=uDefineBiaodanService.searchById(id);
		model.addAttribute("udBiaodan", bean);
		
		List<FlowDefine> flowList=flowDefineService.searchByIsEnabled(1);//查询所有可用的流程
		model.addAttribute("flowList", flowList);
		
		System.out.println(flowList.size());
		return "udefine/flowAdd";
	}
	/**
	 * 保存表单的流程信息
	 * @param id
	 * @param flowid
	 * @return
	 */
	@RequestMapping("/flowSave")
	public String flowSave(Integer id,Integer flowid) {
       
		
		UdefineBiaodan bean=new UdefineBiaodan();
		System.out.println(flowid);
		if(flowid!=null&&flowid>0){
			bean.setFlowid(flowid);
			uDefineBiaodanService.updateById(id, bean);
		}
		
		return "forward:biaodanList";
	}
	/**
	 * 跳转到表单设计页面
	 * @param id
	 * @param flowid
	 * @return
	 */
	@RequestMapping("/designBiaodan")
	public String designBiaodan(Integer id,Model model) {
		
        UdefineBiaodan bean=uDefineBiaodanService.searchById(id);
		
		model.addAttribute("udBiaodan", bean);
		
		return "udefine/biaodanDesign";
	}
	@RequestMapping("/designSave")
	public String designSave(String dataElements,Integer id,Model model) {
		
        UdefineBiaodan bean=uDefineBiaodanService.searchById(id);
		bean.setDcontent(dataElements);
		uDefineBiaodanService.updateById(id, bean);
		
		return "forward:biaodanList";
	}
	
}

