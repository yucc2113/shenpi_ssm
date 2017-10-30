package com.ccgj.service.inter;

import java.util.Date;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Systemlog;

public interface SystemlogService {
	//查询系统日志
	public List<Systemlog> searchSystemlogList();
	/**
	 * 分页查询系统日志
	 * @param pageNum   当前页数
	 * @return
	 */
	public CommonPage<Systemlog> searchSystemlogListByNameAndDateByPage(String name,Date startDate,Date endDate,Integer pageNum);
	public CommonPage<Systemlog> searchSystemlogListByPage(Integer pageNum);
   
	public int insertSystemlog(String username,Integer userId,String content);
}
