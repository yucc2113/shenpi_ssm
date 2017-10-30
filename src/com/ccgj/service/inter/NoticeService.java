package com.ccgj.service.inter;

import java.util.Date;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Notice;
import com.ccgj.database.custom.beans.NoticeCustom;


public interface NoticeService {
	  public  CommonPage<NoticeCustom> searchNewsByTitleAndDateListWithPage(String title,Date startDate,Date endDate,Integer pageNum);
	  
	  public CommonPage<NoticeCustom> searchNewsByTitleAndDateAndUserIdWithPage(Integer userId,String title,Date startDate,Date endDate,Integer pageNum);
	  
	  public List<NoticeCustom> searchNewsByTitleAndDateAndUserId(Integer userId,String title,Date startDate,Date endDate);
	  public int insertNotice(Notice notice);
	  public List<Notice> searchByBeans(Notice notice);
	  
	  public Notice searchNoticeById(Integer id);
	  
	  public int updateNoticeById(Integer id,Notice notice);
	  
	  //根据id删除信息
	  public int deleteNoticeById(Integer id);
	
}
