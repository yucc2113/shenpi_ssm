package com.ccgj.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Dict;
import com.ccgj.database.beans.Role;
import com.ccgj.database.custom.beans.DictCustom;
import com.ccgj.service.inter.DictService;

@Controller
@RequestMapping("dict")
public class DictController {
	@Autowired
   private DictService dictService;
	@RequestMapping("/dictList")
   public String dictList(Model model){
	   //顶级字典列表
		List<Dict> topList=dictService.searchDictListByParentIdAndName(0, null);
	   //次级字典表
		CommonPage<Dict> commonPage=dictService.searchDictListByParentIdAndNameWithPage(null, null, null);
		List<DictCustom> list=new ArrayList<DictCustom>();
		CommonPage<DictCustom> resultPage=new CommonPage<DictCustom>();
		for(int i=0;i<commonPage.getDataList().size();i++){
			Dict bean=commonPage.getDataList().get(i);
			Dict parent=dictService.searchDictById(bean.getParentid());
			DictCustom dictCustom=new DictCustom();
			
		    BeanUtils.copyProperties(bean, dictCustom);
		    dictCustom.setParentName(parent.getProp());
		    list.add(dictCustom);
		}
	//	resultPage=BeanUtil.toPagedResult(list);
		resultPage.setDataList(list);
		resultPage.setPageNo(commonPage.getPageNo());
		resultPage.setPages(commonPage.getPages());
		resultPage.setPageSize(commonPage.getPageSize());
		resultPage.setTotal(commonPage.getTotal());
		model.addAttribute("topList", topList);
		model.addAttribute("resultPage", resultPage);
		//model.addAttribute("commonPage", commonPage);
	   return "system/dictList";
   }
	
	@RequestMapping("/ajaxDictList")
	   public @ResponseBody CommonPage<DictCustom> ajaxDictList(Integer parentId,String searchName,Integer pageNum){
		   System.out.println("parentId="+parentId);
		   if(parentId==null||parentId==-1)parentId=null;
			CommonPage<Dict> commonPage=dictService.searchDictListByParentIdAndNameWithPage(parentId, searchName, pageNum);
			List<DictCustom> list=new ArrayList<DictCustom>();
			CommonPage<DictCustom> resultPage=new CommonPage<DictCustom>();
			for(int i=0;i<commonPage.getDataList().size();i++){
				Dict bean=commonPage.getDataList().get(i);
				Dict parent=dictService.searchDictById(bean.getParentid());
				DictCustom dictCustom=new DictCustom();
				
			    BeanUtils.copyProperties(bean, dictCustom);
			    dictCustom.setParentName(parent.getProp());
			    list.add(dictCustom);
			}
		
			resultPage.setDataList(list);
			resultPage.setPageNo(commonPage.getPageNo());
			resultPage.setPages(commonPage.getPages());
			resultPage.setPageSize(commonPage.getPageSize());
			resultPage.setTotal(commonPage.getTotal());

		   return resultPage;
	   }
	@RequestMapping("/dictAdd")
	public String dictAdd(Model model){
		List<Dict> topList=dictService.searchDictListByParentIdAndName(0, null);
	   System.out.println("-----------------"+topList.size());
		model.addAttribute("topList", topList);
		return "system/dictAdd";
	}
	@RequestMapping("/dictSave")
	public  String dictSave(Integer id,String prop,Integer parentId){
		if(parentId==null||parentId==-1){
			parentId=0;
		}
		if(id!=null&&id>0){
			Dict dict=new Dict();
			dict.setId(id);
			dict.setParentid(parentId);
			dict.setFlag(1);
			dict.setProp(prop);
			dict.setTypes(parentId+"");
			if(parentId==0){
				dict.setMemos("顶级");
			}
			
			dictService.updateDictById(id, dict);
		}else{
			dictService.insertDict(prop, parentId);
		}
		
		
		return "forward:dictList";
	}
	@RequestMapping("/dictUpdate")
	public String dictUpdate(Model model,Integer id){
		List<Dict> topList=dictService.searchDictListByParentIdAndName(0, null);
		Dict dict=dictService.searchDictById(id);
		 model.addAttribute("topList", topList);
	    model.addAttribute("dict", dict);
		return "system/dictAdd";
	}
	
	@RequestMapping("/dictDelete")
	public  String dictDelete(HttpServletResponse response, Integer[] ids){
		response.setCharacterEncoding("utf-8");
		for(int i=0;i<ids.length;i++){
			int id=ids[i];
			dictService.deleteDictById(id);
		}
		return "forward:dictList";
	}
}
