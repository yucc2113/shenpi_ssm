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
import com.ccgj.database.beans.FlowStep;
import com.ccgj.database.beans.FlowWork;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.UdefineBiaodan;
import com.ccgj.database.beans.UflowBiaodan;
import com.ccgj.database.beans.UflowValue;
import com.ccgj.database.beans.UflowWork;
import com.ccgj.database.beans.UliuchengBiaodan;
import com.ccgj.database.beans.UliuchengValue;
import com.ccgj.database.beans.Users;

import com.ccgj.service.inter.FlowDefineService;
import com.ccgj.service.inter.FlowStepService;
import com.ccgj.service.inter.UFlowBiaodanService;
import com.ccgj.service.inter.UFlowValueService;
import com.ccgj.service.inter.UFlowWorkService;
import com.ccgj.service.inter.UdefineBiaodanService;


@Controller
@RequestMapping("flowBiaodan")
public class FlowBiaodanController {
	@Autowired
	private FlowDefineService flowDefineService;
	
	@Autowired
	private FlowStepService flowStepService;
	@Autowired
	private UdefineBiaodanService udBiaodanService;
	@Autowired
	private UFlowBiaodanService uFlowBiaodanService;
	@Autowired
	private UFlowValueService uflowValueService;
	@Autowired
	private UFlowWorkService uflowWorkService;
   
	
	@RequestMapping("/list")
	   public String list(HttpServletRequest request,Model model){
		  Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
		  UflowBiaodan benaBiaodan=new UflowBiaodan();
		 CommonPage<UflowBiaodan> commonPage=uFlowBiaodanService.searchByNameAndDateAndUserWithPage(null, null, null, user, 1);
		 model.addAttribute("commonPage", commonPage);
		  return "biaodan/biaodanList";
	   }
	@RequestMapping("/ajaxList")
	public @ResponseBody
	CommonPage<UflowBiaodan> ajaxList(HttpServletRequest request, Integer pageNum,
			String searchName, @RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate) {
		 Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
		if (searchName == null || searchName.length() <= 0)
			searchName = null;
		CommonPage<UflowBiaodan> commonPage = uFlowBiaodanService.searchByNameAndDateAndUserWithPage(searchName, startDate,
						endDate,user, pageNum);
		return commonPage;
	}
   /**
    * 流程启用页面
    * @param flowId
    * @param model
    * @return
    */
   @RequestMapping("/add")
   public String add(Integer flowId ,Model model){
	  FlowDefine bean= flowDefineService.searchById(flowId);
	  UdefineBiaodan biaodan=udBiaodanService.searchById(bean.getBiaodanId());
	 // model.addAttribute("biaodan", biaodan);
	  if(biaodan!=null){
		  model.addAttribute("dcontent", biaodan.getDcontent());
		  model.addAttribute("flowId", flowId);
		  model.addAttribute("biaoId", biaodan.getId());
		  model.addAttribute("mingchen",biaodan.getMingchen());
	  }
	
	 // model.addAttribute("flow", bean);
	   return "biaodan/biaodanAdd";
   }
   
   /**
    * 流程启用保存
    * @param request
    * @param bean
    * @param flowId
    * @param biaoId
    * @param dataElement
    * @param model
    * @return
    */
   @RequestMapping("/save")
   public String save(HttpServletRequest request,UflowBiaodan bean,
		   Integer flowId,Integer biaoId,String [] dataElement,Model model){
	     Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
	

	     UdefineBiaodan biaodan=udBiaodanService.searchById(biaoId);
       //主表存储（用户流程表单）
		bean.setCreatedate(new Date());
		bean.setCreateuser(user.getId());
		bean.setCreatename(user.getUsername());
		bean.setFlowid(flowId);
		bean.setState(1);
		bean.setDcontent(biaodan.getDcontent());
		uFlowBiaodanService.insert(bean);
		
		//把表单填入的值写入UflowValue表中
		 List<Strbean> result = WebFormatter.html2List(biaodan.getDcontent());
		 
		
		 if(result!=null&&result.size()>0){
			   for(int i=0;i<result.size();i++){
				   UflowValue detail = new UflowValue();
				   detail.setBaiodanid(bean.getId());
				   detail.setDataelement(dataElement[i]);
				   detail.setDataelementtype(WebFormatter.gettype(result.get(i).getStrCode()));
				   uflowValueService.insert(detail);
			   }
		  }
		 //查询所有的开始步骤,启动流程
		 List<FlowStep> liststep=flowStepService.searchByZhuIdAndLastId(flowId, 0);
		 if(liststep!=null&&liststep.size()>0){
			 for(int i=0;i<liststep.size();i++){
					FlowStep beanstep = liststep.get(i);
					UflowWork workbean=new UflowWork();
					workbean.setAddTime(new Date());
					workbean.setDealDate(new Date());
	    			workbean.setFlowId(beanstep.getFlowId());
	    			workbean.setWorkId(bean.getId());
	    			workbean.setStepId(beanstep.getId());
	    			workbean.setStepNo(beanstep.getStepNo());
	    			workbean.setShenpileixing(Integer.valueOf(beanstep.getLeixing()));
    				workbean.setStatus(1);
	    			workbean.setDealName(beanstep.getLibusername());
	    			if(beanstep.getStepType()==1l){
	    				workbean.setDealUser(Integer.valueOf(beanstep.getDealUser()));
	    				workbean.setDealPosition(0);
	    				workbean.setDealRole(0);
	    			
	    			}else if(beanstep.getStepType()==2l){
	    				workbean.setDealUser(0);
	    				workbean.setDealPosition(0);
	    				
	    				workbean.setDealRole(beanstep.getDealRole());
	    			}else if(beanstep.getStepType()==3l){
	    				workbean.setDealUser(0);
	    				workbean.setDealPosition(Integer.valueOf(beanstep.getDealPosition()));
	    				workbean.setDealRole(0);
	    			}
	    			
	    			uflowWorkService.insert(workbean);
			 }
		 }
		   return "forward:list";
	   }
   
   @RequestMapping("/update")
   public String update(Integer id ,Model model){
	  
	  UflowBiaodan uflowBiaodan=uFlowBiaodanService.searchById(id);
	  List<UflowValue> list=uflowValueService.searchByBiaodanId(uflowBiaodan.getId());
	 
	  FlowDefine bean= flowDefineService.searchById(uflowBiaodan.getFlowid());
	  UdefineBiaodan biaodan=udBiaodanService.searchById(bean.getBiaodanId());
	  if(biaodan!=null){
		  model.addAttribute("id", uflowBiaodan.getId());
		  model.addAttribute("dcontent", WebFormatter.getStr(uflowBiaodan.getDcontent(), list,1l));
		  model.addAttribute("flowId", uflowBiaodan.getFlowid());
		  model.addAttribute("biaoId", biaodan.getId());
		  model.addAttribute("mingchen",biaodan.getMingchen());
	  }
	 
	   return "biaodan/biaodanAdd";
   }
   @RequestMapping("/updateSave")
   public String updateSave(Integer id,Model model,String [] dataElement){
	       
		UflowBiaodan uflowBiaodan = uFlowBiaodanService.searchById(id);
		// 删除子表信息
		uflowValueService.deleteByZhuId(id);
		// 把表单填入的值写入UflowValue表中
		List<Strbean> result = WebFormatter.html2List(uflowBiaodan
				.getDcontent());

		if (result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				UflowValue detail = new UflowValue();
				detail.setBaiodanid(id);
				detail.setDataelement(dataElement[i]);
				detail.setDataelementtype(WebFormatter.gettype(result.get(i)
						.getStrCode()));
				uflowValueService.insert(detail);
			}
		}

	   return "forward:list";
   }
   
   
   @RequestMapping("/delete")
   public String delete(Integer[] ids,Model model){
	   for(int i=0;i<ids.length;i++){
			//删除子表信息
			uflowValueService.deleteByZhuId(ids[i]);
			uflowWorkService.deleteByZhuId(ids[i]);
			uFlowBiaodanService.deleteById(ids[i]);
	   }
	   return "forward:list";
   }
   
   @RequestMapping("/detail")
  	public String detail(HttpServletRequest request,Integer id,Model model,Integer flag){
      	Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
      	UflowBiaodan uflowBiaodan= uFlowBiaodanService.searchById(id);
      	model.addAttribute("uflowBiaodan", uflowBiaodan);

      	List<UflowValue> list=uflowValueService.searchByBiaodanId(uflowBiaodan.getId());
      
      	model.addAttribute("dcontent", WebFormatter.getStr(uflowBiaodan.getDcontent(), list,2l));
      
      	List<UflowWork> ideaList = uFlowBiaodanService.searchUflowWorkByFlowIdAndWorkIdAndState(uflowBiaodan.getFlowid(), uflowBiaodan.getId());
      
      	
      	String detail_type="";
      	if(ideaList!=null&&ideaList.size()>0){
			detail_type="1";
		}
      	model.addAttribute("ideaList", ideaList);
      	model.addAttribute("detail_type", detail_type);
      	
    	String auditIdea="";
      	UflowWork workBeangangwei = new UflowWork();
		workBeangangwei.setWorkId(id);
		workBeangangwei.setDealPosition(user.getPositionid());
		workBeangangwei.setShenpileixing(3);
		workBeangangwei.setStatus(1);
		List workListPosition = uflowWorkService.searchUflowWorkByBean(workBeangangwei);
		if(workListPosition!=null&&workListPosition.size()>0){
			auditIdea = "1";
		} 
		
		UflowWork workBeanrole = new UflowWork();
		workBeanrole.setWorkId(id);
		workBeanrole.setDealRole(user.getRoleid());
		workBeanrole.setShenpileixing(2);
		workBeanrole.setStatus(1);
		List workListrole = uflowWorkService.searchUflowWorkByBean(workBeanrole);
		if(workListrole!=null&&workListrole.size()>0){
			auditIdea = "1";
		}
		
		UflowWork workBeanuser = new UflowWork();
		workBeanuser.setWorkId(id);
		workBeanuser.setDealUser(user.getId());
		workBeanuser.setStatus(1);
		workBeanuser.setShenpileixing(1);
		List workListUser = uflowWorkService.searchUflowWorkByBean(workBeanuser);
		if(workListUser!=null&&workListUser.size()>0){
			auditIdea = "1";
		}
		
		model.addAttribute("auditIdea", auditIdea);
		model.addAttribute("flag", flag);
		return "biaodan/biaodanDetail";
  	}
    /**
     * 流程审批列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/auditList")
	public String auditlist(HttpServletRequest request,Model model){
    	Users user = (Users)request.getSession().getAttribute(GlobalDefine.USER);
		CommonPage<UflowBiaodan> commonPage= uFlowBiaodanService.searchByUserWithPage(user, 1);
		model.addAttribute("commonPage", commonPage);
    	return "biaodan/biaodanAuditList";
	}
    /**
     * 审批保存页面
     * @param type(1:审批通过;2:不通过)
     * @param model
     * @return
     */
    @RequestMapping("/audit")
	public String audit(Integer id,Integer type,String dealIdea,Model model){
    	UflowBiaodan uflowBiaodan= uFlowBiaodanService.searchById(id);
    	//查询宏定义
    	UflowValue value=new UflowValue();
    	value.setBaiodanid(uflowBiaodan.getId());
    	value.setDataelementtype("element_auto");
    	List<UflowValue> listValue=uflowValueService.searchByBean(value);
    	String hongContent = "";
		if(listValue!=null&&listValue.size()>0){
			 hongContent = listValue.get(0).getDataelement()!=null?listValue.get(0).getDataelement():"0";
		}if(type!=null&&type==2l){//不通过
			uflowBiaodan.setState(4);
			//return "forward:auditList";
		}else{
			uflowBiaodan.setState(2);//正在处理
		}
		UflowWork searchBean=new UflowWork();
		searchBean.setWorkId(id);
		searchBean.setStatus(1);
		List<UflowWork> workList = uflowWorkService.searchUflowWorkByBean(searchBean);
		
		//当前步骤
		UflowWork uflowWork=workList.get(0);
		FlowStep tFlowStepnow = flowStepService.searchById(uflowWork.getStepId());
		//查询当前步骤
		if(tFlowStepnow.getNextId()==0||tFlowStepnow.getNextId()==-1){//没有下一步
			uflowWork.setStatus(2);
			uflowWork.setDealIdea(dealIdea);
			uflowWorkService.updateById(uflowWork);
		    if(type!=null&&type==2l){
			   uflowBiaodan.setState(4);//主表不通过
		    }else{
		    	 uflowBiaodan.setState(3);
		    }
		}else{//有下一步
			if(type!=null&&type==2){//有下一步且当前审批不通过
				uflowWork.setStatus(3);
				uflowWork.setDealIdea(dealIdea);
				uflowWorkService.updateById(uflowWork);
				uflowBiaodan.setState(4);//主表不通过
				
			}else{//有下一步且当前审批通过
				uflowWork.setStatus(2);
				uflowWork.setDealIdea(dealIdea);
				uflowWorkService.updateById(uflowWork);
				
				uflowBiaodan.setState(2);//主表处理中
				//查询下一步
				FlowStep nextbean =new FlowStep();
				
				List<FlowStep> nextList=flowStepService.searchByZhuIdAndLastId(uflowBiaodan.getFlowid(),uflowWork.getStepId());
				if(nextList!=null&&nextList.size()>0){
					for(int i=0;i<nextList.size();i++){
						FlowStep tFlowStep = nextList.get(i);
						//1:'大于',2:'小于',3:'等于',4:'大于等于',5:'小于等于'
						if(tFlowStep.getConditions().equals("1")){
							if(Long.valueOf(hongContent)>Long.valueOf(tFlowStep.getConditionmsg())){
								UflowWork workbean = new UflowWork();
								workbean.setAddTime(new Date());
								workbean.setDealDate(new Date());
								workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
								workbean.setFlowId(tFlowStep.getFlowId());
								workbean.setWorkId(uflowBiaodan.getId());
								workbean.setStepId(tFlowStep.getId());
								workbean.setStepNo(tFlowStep.getStepNo());
								workbean.setShenpileixing(tFlowStep.getStepType());
			    				workbean.setStatus(1);
			    				if(tFlowStep.getStepType()==1){
				    				workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
				    				workbean.setDealPosition(0);
				    				workbean.setDealRole(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    			}else if(tFlowStep.getStepType()==2){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(tFlowStep.getDealRole());
				    			}else if(tFlowStep.getStepType()==3){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(Integer.valueOf(tFlowStep.getDealPosition()));
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(0);
				    			}
								uflowWorkService.insert(workbean);
							}
						}else if(tFlowStep.getConditions().equals("2")){
							if(Long.valueOf(hongContent)<Long.valueOf(tFlowStep.getConditionmsg())){
								UflowWork workbean = new UflowWork();
								workbean.setAddTime(new Date());
								workbean.setDealDate(new Date());
								workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
								workbean.setFlowId(tFlowStep.getFlowId());
								workbean.setWorkId(uflowBiaodan.getId());
								workbean.setStepId(tFlowStep.getId());
								workbean.setStepNo(tFlowStep.getStepNo());
								workbean.setShenpileixing(tFlowStep.getStepType());
			    				workbean.setStatus(1);
			    				if(tFlowStep.getStepType()==1){
				    				workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
				    				workbean.setDealPosition(0);
				    				workbean.setDealRole(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    			}else if(tFlowStep.getStepType()==2){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(tFlowStep.getDealRole());
				    			}else if(tFlowStep.getStepType()==3){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(Integer.valueOf(tFlowStep.getDealPosition()));
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(0);
				    			}
								uflowWorkService.insert(workbean);
							}
					    }else if(tFlowStep.getConditions().equals("3")){
							if(Long.valueOf(hongContent)==Long.valueOf(tFlowStep.getConditionmsg())){
								UflowWork workbean = new UflowWork();
								workbean.setAddTime(new Date());
								workbean.setDealDate(new Date());
								workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
								workbean.setFlowId(tFlowStep.getFlowId());
								workbean.setWorkId(uflowBiaodan.getId());
								workbean.setStepId(tFlowStep.getId());
								workbean.setStepNo(tFlowStep.getStepNo());
								workbean.setShenpileixing(tFlowStep.getStepType());
			    				workbean.setStatus(1);
			    				if(tFlowStep.getStepType()==1){
				    				workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
				    				workbean.setDealPosition(0);
				    				workbean.setDealRole(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    			}else if(tFlowStep.getStepType()==2){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(tFlowStep.getDealRole());
				    			}else if(tFlowStep.getStepType()==3){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(Integer.valueOf(tFlowStep.getDealPosition()));
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(0);
				    			}
								uflowWorkService.insert(workbean);
							}
					    }else if(tFlowStep.getConditions().equals("4")){
							if(Long.valueOf(hongContent)>=Long.valueOf(tFlowStep.getConditionmsg())){
								UflowWork workbean = new UflowWork();
								workbean.setAddTime(new Date());
								workbean.setDealDate(new Date());
								workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
								workbean.setFlowId(tFlowStep.getFlowId());
								workbean.setWorkId(uflowBiaodan.getId());
								workbean.setStepId(tFlowStep.getId());
								workbean.setStepNo(tFlowStep.getStepNo());
								workbean.setShenpileixing(tFlowStep.getStepType());
			    				workbean.setStatus(1);
			    				if(tFlowStep.getStepType()==1){
				    				workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
				    				workbean.setDealPosition(0);
				    				workbean.setDealRole(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    			}else if(tFlowStep.getStepType()==2){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(tFlowStep.getDealRole());
				    			}else if(tFlowStep.getStepType()==3){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(Integer.valueOf(tFlowStep.getDealPosition()));
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(0);
				    			}
								uflowWorkService.insert(workbean);
							}
					    }else if(tFlowStep.getConditions().equals("5")){
							if(Long.valueOf(hongContent)<=Long.valueOf(tFlowStep.getConditionmsg())){
								UflowWork workbean = new UflowWork();
								workbean.setAddTime(new Date());
								workbean.setDealDate(new Date());
								workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
								workbean.setFlowId(tFlowStep.getFlowId());
								workbean.setWorkId(uflowBiaodan.getId());
								workbean.setStepId(tFlowStep.getId());
								workbean.setStepNo(tFlowStep.getStepNo());
								workbean.setShenpileixing(tFlowStep.getStepType());
			    				workbean.setStatus(1);
			    				if(tFlowStep.getStepType()==1){
				    				workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
				    				workbean.setDealPosition(0);
				    				workbean.setDealRole(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    			}else if(tFlowStep.getStepType()==2){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(0);
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(tFlowStep.getDealRole());
				    			}else if(tFlowStep.getStepType()==3){
				    				workbean.setDealUser(0);
				    				workbean.setDealPosition(Integer.valueOf(tFlowStep.getDealPosition()));
				    				workbean.setDealName(tFlowStep.getLibusername());
				    				workbean.setDealRole(0);
				    			}
								uflowWorkService.insert(workbean);
							}
					    }else{
					    	UflowWork workbean = new UflowWork();
							workbean.setAddTime(new Date());
							workbean.setDealDate(new Date());
							workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
							workbean.setFlowId(tFlowStep.getFlowId());
							workbean.setWorkId(uflowBiaodan.getId());
							workbean.setStepId(tFlowStep.getId());
							workbean.setStepNo(tFlowStep.getStepNo());
							workbean.setShenpileixing(tFlowStep.getStepType());
		    				workbean.setStatus(1);
		    				if(tFlowStep.getStepType()==1){
			    				workbean.setDealUser(Integer.valueOf(tFlowStep.getDealUser()));
			    				workbean.setDealPosition(0);
			    				workbean.setDealRole(0);
			    				workbean.setDealName(tFlowStep.getLibusername());
			    			}else if(tFlowStep.getStepType()==2){
			    				workbean.setDealUser(0);
			    				workbean.setDealPosition(0);
			    				workbean.setDealName(tFlowStep.getLibusername());
			    				workbean.setDealRole(tFlowStep.getDealRole());
			    			}else if(tFlowStep.getStepType()==3){
			    				workbean.setDealUser(0);
			    				workbean.setDealPosition(Integer.valueOf(tFlowStep.getDealPosition()));
			    				workbean.setDealName(tFlowStep.getLibusername());
			    				workbean.setDealRole(0);
			    			}
							uflowWorkService.insert(workbean);
					    }
						
					}	
					
				}
			
			}
		}
		uFlowBiaodanService.updateById(uflowBiaodan);
    	return "forward:auditList";
	}
    
}
