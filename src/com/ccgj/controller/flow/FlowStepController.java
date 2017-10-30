package com.ccgj.controller.flow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.util.StringUtil;
import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.FlowDefine;
import com.ccgj.database.beans.FlowStep;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.custom.beans.FlowStepCustom;
import com.ccgj.service.inter.FlowDefineService;
import com.ccgj.service.inter.FlowStepService;

@Controller
@RequestMapping("flowstep")
public class FlowStepController {
	@Autowired
	private FlowDefineService flowDefineService;
	@Autowired
	private FlowStepService flowStepService;
	@RequestMapping("/list")
    public String  list(Integer flowId,String searchName,Model model){
    	
    	List<FlowDefine> flowList=flowDefineService.searchByIsEnabled(1);
    	
    	List<FlowStep> stepList=null;
    	if(flowList!=null && flowList.size()>0 && flowId==null){
			stepList=flowStepService.searchByZhuIdAndName(flowList.get(0).getId(), searchName);
			model.addAttribute("flowId", flowList.get(0).getId());
    	}else{
			stepList=flowStepService.searchByZhuIdAndName(flowId, searchName);
			model.addAttribute("flowId", flowId);
		}
    	 
        List<FlowStepCustom>	stepCustomList=new ArrayList<FlowStepCustom>();
        for(int i=0;i<stepList.size();i++){
        	FlowStepCustom stepCustom=new FlowStepCustom();
        	FlowStep bean=stepList.get(i);
        	BeanUtils.copyProperties(bean, stepCustom);
        	if(bean.getLeixing().equals("1")){
        		stepCustom.setLeibiename("开始");
			}else if(bean.getLeixing().equals("2")){
				stepCustom.setLeibiename("串行");
			}else if(bean.getLeixing().equals("3")){
				stepCustom.setLeibiename("并行");
			}else if(bean.getLeixing().equals("4")){
				stepCustom.setLeibiename("任务");
			}else if(bean.getLeixing().equals("5")){
				stepCustom.setLeibiename("结束");
			}
        	//上级步骤
        	FlowStep last=flowStepService.searchById(bean.getLastId());
        	if(last!=null){
        		stepCustom.setLastname(last.getStepName());
        	}else{
        		stepCustom.setLastname("无");
        	}
        	//下级步骤
        	FlowStep next=flowStepService.searchById(bean.getNextId());
        	System.out.println("next="+next);
        	if(next!=null){
        		stepCustom.setNextname(next.getStepName());
        	}else{
        		stepCustom.setNextname("无");
        	}
        	
        	stepCustomList.add(stepCustom);
        }
    	model.addAttribute("flowList", flowList);
    	model.addAttribute("stepCustomList", stepCustomList);
    	return "flow/flowStepList";
    }
	
	@RequestMapping("/ajaxList")
	public @ResponseBody  List<FlowStepCustom> ajaxList(Integer flowId,String searchName) {
		
		List<FlowStep> stepList=flowStepService.searchByZhuIdAndName(flowId, searchName);
		
		List<FlowStepCustom>stepCustomList=new ArrayList<FlowStepCustom>();
	        for(int i=0;i<stepList.size();i++){
	        	FlowStepCustom stepCustom=new FlowStepCustom();
	        	FlowStep bean=stepList.get(i);
	        	BeanUtils.copyProperties(bean, stepCustom);
	        	if(bean.getLeixing().equals("1")){
	        		stepCustom.setLeibiename("开始");
				}else if(bean.getLeixing().equals("2")){
					stepCustom.setLeibiename("串行");
				}else if(bean.getLeixing().equals("3")){
					stepCustom.setLeibiename("并行");
				}else if(bean.getLeixing().equals("4")){
					stepCustom.setLeibiename("任务");
				}else if(bean.getLeixing().equals("5")){
					stepCustom.setLeibiename("结束");
				}
	        	//上级步骤
	        	FlowStep last=flowStepService.searchById(bean.getLastId());
	        	if(last!=null){
	        		stepCustom.setLastname(last.getStepName());
	        	}else{
	        		stepCustom.setLastname("无");
	        	}
	        	//下级步骤
	        	FlowStep next=flowStepService.searchById(bean.getNextId());
	        	if(next!=null){
	        		stepCustom.setNextname(next.getStepName());
	        	}else{
	        		stepCustom.setNextname("无");
	        	}
	        	
	        	stepCustomList.add(stepCustom);
	        }
		return stepCustomList;
	}
	
	@RequestMapping("/add")
    public String  add(Integer flowId,Model model){
    	List stepList=flowStepService.searchByZhuIdAndName(flowId, null);
    	model.addAttribute("lastList", stepList);
    	model.addAttribute("nextList", stepList);
    	model.addAttribute("flowId", flowId);
    	return "flow/flowStepAdd";
    }
	@RequestMapping("/save")
    public String save(FlowStep flowStep,Integer flowId,Model model){
    	
    	flowStep.setFlowId(flowId);
    	flowStep.setAddTime(new Date());
    	flowStep.setFlag(1);
    	
    	if(flowStep.getLeixing().equals("1")){//开始，上一步为0
    		flowStep.setLastId(0);
    		flowStepService.insert(flowStep);
    		if(flowStep.getNextId()!=-1){//flowStep的下一步是stepBean;
    			FlowStep stepBean=flowStepService.searchById(flowStep.getNextId());
    			stepBean.setLastId(flowStep.getId());
    			flowStepService.update(stepBean.getId(), stepBean);
    		}
    	}else if(flowStep.getLeixing().equals("5")){//结束 下一步0
    		flowStep.setNextId(0);
    		flowStepService.insert(flowStep);
    		
    		if(flowStep.getLastId()!= -1){//flowStep的上一步是stepBean;
				FlowStep stepBean = flowStepService.searchById(flowStep.getLastId());
				stepBean.setNextId(flowStep.getId());
				flowStepService.update(stepBean.getId(),stepBean);
			}
    	}else{
			
    		flowStepService.insert(flowStep);
			if(flowStep.getNextId() != -1){//flowStep的下一步是stepBean;
				FlowStep stepBean = flowStepService.searchById(flowStep.getNextId());
				stepBean.setLastId(flowStep.getId());
				flowStepService.update(stepBean.getId(),stepBean);
			}
			if(flowStep.getLastId()!= -1){//flowStep的上一步是stepBean;
				FlowStep stepBean = flowStepService.searchById(flowStep.getLastId());
				stepBean.setNextId(flowStep.getId());
				flowStepService.update(stepBean.getId(),stepBean);
			}
			
		}
    	
    	
    	return "forward:list";
    }
	
	@RequestMapping("/update")
    public String  update(Integer flowId,Integer id,Model model){
		FlowStep flowStep=flowStepService.searchById(id);
    	List stepList=flowStepService.searchByZhuIdAndName(flowId, null);
    	model.addAttribute("lastList", stepList);
    	model.addAttribute("nextList", stepList);
    	model.addAttribute("flowId", flowId);
    	model.addAttribute("id", id);
    	model.addAttribute("flowStep", flowStep);
    	return "flow/flowStepAdd";
    }
	@RequestMapping("/updateSave")
    public String updateSave(FlowStep flowStep,Integer flowId,Model model){
		if (flowStep.getStepType()==1) {    // 1: 按人员 2： 按角色 3：按岗位
			flowStep.setDealRole(0);
			flowStep.setDealPosition("0");
		}else if (flowStep.getStepType()==2) {
			flowStep.setDealUser("0");
			flowStep.setDealPosition("0");
		}else if (flowStep.getStepType()==3) {
			flowStep.setDealUser("0");
			flowStep.setDealRole(0);
		}
		
		if(flowStep.getLeixing().equals("1")){//开始，上一步为0
    		flowStep.setLastId(0);
    		flowStepService.update(flowStep.getId(),flowStep);
    		if(flowStep.getNextId()!=-1){//flowStep的下一步是stepBean;
    			FlowStep stepBean=flowStepService.searchById(flowStep.getNextId());
    			stepBean.setLastId(flowStep.getId());
    			flowStepService.update(stepBean.getId(), stepBean);
    		}
    	}else if(flowStep.getLeixing().equals("5")){//结束 下一步0
    		flowStep.setNextId(0);
    		flowStepService.update(flowStep.getId(),flowStep);
    		
    		if(flowStep.getLastId()!= -1){//flowStep的上一步是stepBean;
				FlowStep stepBean = flowStepService.searchById(flowStep.getLastId());
				stepBean.setNextId(flowStep.getId());
				flowStepService.update(stepBean.getId(),stepBean);
			}
    	}else{
			
    		flowStepService.update(flowStep.getId(),flowStep);
			if(flowStep.getNextId() != -1){//flowStep的下一步是stepBean;
				FlowStep stepBean = flowStepService.searchById(flowStep.getNextId());
				stepBean.setLastId(flowStep.getId());
				flowStepService.update(stepBean.getId(),stepBean);
			}
			if(flowStep.getLastId()!= -1){//flowStep的上一步是stepBean;
				FlowStep stepBean = flowStepService.searchById(flowStep.getLastId());
				stepBean.setNextId(flowStep.getId());
				flowStepService.update(stepBean.getId(),stepBean);
			}
			
		}
		
		return "forward:list";
	}
	@RequestMapping("/delete")
    public String  delete(Integer[] ids){
		for(int i=0;i<ids.length;i++){
			FlowStep flowStep = flowStepService.searchById(ids[i]);
			if(flowStep!=null&&flowStep.getId()!=null){
				flowStep.setFlag(2);
				flowStepService.update(flowStep.getId(),flowStep);
			}
		}
    	return "forward:list";
    }
	
}
