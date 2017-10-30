package com.ccgj.service.inter;

import java.util.Date;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.Meet;
import com.ccgj.database.custom.beans.MeetCustom;


public interface MeetService {
	CommonPage<Meet> searchMeetByNameAndDateWithPage(String name,Date startDate,Date endDate,Integer pageNum);
	CommonPage<Meet> searchMeetByNameAndDateAndUserIdWithPage(Integer userId,String name,Date startDate,Date endDate,Integer pageNum);
  
	public Meet searchMeetById(Integer id);
	
	public int updateMeetById(Integer id,Meet meet);
	public int insertMeet(Meet meet);
    
    public int deleteMeetById(Integer id);
    
 
}
