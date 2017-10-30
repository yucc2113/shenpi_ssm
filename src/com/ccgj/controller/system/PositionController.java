package com.ccgj.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Position;
import com.ccgj.database.beans.Role;
import com.ccgj.service.inter.PositionService;

@Controller
@RequestMapping("position")
public class PositionController {
	@Autowired
    private PositionService positionService;
	
	/**
	 * 初始化职位列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/positionList")
	public String PositionList(Model model){
		CommonPage<Position> commonPage=positionService.searchPositionListByNameWithPage(null, null);
		model.addAttribute("commonPage", commonPage);
		return "system/positionList";
	}
	
	/**
	 * 根据名称查询职位列表并进行分页
	 * @param searchName
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/ajaxPositionList")
	public @ResponseBody CommonPage ajaxPositionList(String searchName,Integer pageNum){
		CommonPage<Position> commonPage=positionService.searchPositionListByNameWithPage(searchName, pageNum);
		return commonPage;
	}
	/**
	 * 跳转到添加职位列表的页面
	 * @return
	 */
	@RequestMapping("/positionAdd")
	public String positionAdd(){
		return "system/positionAdd";
	}
	
	/**
	 * 新增职位
	 * @param position
	 * @return
	 */
	@RequestMapping("/positionSave")
	public String positionSave(Position position){
		if(position.getId()!=null&&position.getId()>0){
			positionService.updatePositionById(position.getId(), position);
		}else{
			positionService.insert(position);
		}
		return "forward:positionList";
	}
	/**
	 * 跳转到更新页面
	 * @param position
	 * @return
	 */
	@RequestMapping("/positionUpdate")
	public String positionUpdate(Model model,Integer id){
		if(id!=null&&id>0){
		    Position position=positionService.searchPositionById(id);
		    model.addAttribute("position", position);
		}
		return "system/positionAdd";
	}
	/**
	 * 根据ID删除一条信息
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/positionDelete")
	public  String positionDelete(HttpServletResponse response, Integer[] ids){
		response.setCharacterEncoding("utf-8");
		for(int i=0;i<ids.length;i++){
			int id=ids[i];
			positionService.deletePositionById(id);
		}
		return "forward:positionList";
	}
	@RequestMapping("/getPositionTree")
	public @ResponseBody List<Map<String, Object>> getPositionTree(HttpServletRequest request) {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();

		List positionList = positionService.searchPositionList();

	
		for (int i = 0; i < positionList.size(); i++) {
			Map<String,Object> tree = new HashMap<String, Object>();
			Position position = (Position) positionList.get(i);
			tree.put("id", position.getId());
			tree.put("text", position.getName());
			tree.put("leaf", true);
			trees.add(tree);
		}

		return trees;
	}
}
