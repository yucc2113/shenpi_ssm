package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Meet;
import com.ccgj.database.beans.MeetUser;
import com.ccgj.database.beans.MeetUserExample;
import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.custom.beans.MeetCustom;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.database.mapper.MeetMapper;
import com.ccgj.database.mapper.MeetUserMapper;
import com.ccgj.service.inter.MeetUserService;

public class MeetUserServiceImp implements MeetUserService{
    @Autowired
	private  MeetUserMapper meetUserMapper;
    @Autowired
   	private  MeetMapper meetMapper;
	@Override
	public int insertMeetUser(MeetUser meetUser) {
	
		return meetUserMapper.insert(meetUser);
	}
	@Override
	public MeetCustom searchMeetCustomByMeetId(Integer meetId) {
	   Meet meet=meetMapper.selectByPrimaryKey(meetId);
	   MeetCustom meetCustom=new MeetCustom();
		BeanUtils.copyProperties(meet, meetCustom);
		List<MeetUser>  list=this.searchMeetUserByMeetId(meetCustom.getId());
		String usersname="";
		String usersId="";
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size()-1;i++){
				usersname+=(list.get(i).getUsername()+",");	
				usersId+=(list.get(i).getUserId()+",");
			}
			usersname+=list.get(list.size()-1).getUsername();
			usersId+=list.get(list.size()-1).getUserId();
		}
		
		
		meetCustom.setUsersId(usersId);
		meetCustom.setUsersName(usersname);
		meetCustom.setNum(list.size());
		return meetCustom;
	}
	@Override
	public List<MeetUser> searchMeetUserByMeetId(Integer meetId) {
		MeetUserExample bean=new MeetUserExample();
		bean.createCriteria().andMeetIdEqualTo(meetId);
		return meetUserMapper.selectByExample(bean);
	}
	@Override
	public int deleteMeetUserByMeetId(Integer meetId) {
		MeetUserExample bean=new MeetUserExample();
		bean.createCriteria().andMeetIdEqualTo(meetId);
		return meetUserMapper.deleteByExample(bean);
	}


}
