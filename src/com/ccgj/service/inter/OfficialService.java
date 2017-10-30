package com.ccgj.service.inter;

import java.util.Date;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Official;
import com.ccgj.database.custom.beans.OfficialCustom;

public interface OfficialService {
  
	//根据文号查询公文
	public List<Official> searchByWenhao(String wenhao);
	//新增公文
	public int insertOfficial(Official official);
	
	//修改公文
	public int updateOfficial(Official official);
	//删除公文
	
	public int deleteById(Integer id);
	
	//查询公文
	public List<Official> searchAllList();
	
	public Official searchById(Integer id);
	//根据公文名称和日期查询公文
	
	public CommonPage<OfficialCustom> searchListByNameAndDateWithPage(String name,Date startDate,Date endDate,Integer pageNum,Integer state);
	
	public CommonPage<OfficialCustom> searchListByNameAndDateAndUserIdWithPage(Integer userId,String name,Date startDate,Date endDate,Integer pageNum,Integer state);
	
}
