package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Notice;
import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.beans.NoticeUserExample;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.database.mapper.NoticeMapper;
import com.ccgj.database.mapper.NoticeUserMapper;
import com.ccgj.service.inter.NoticeUserService;

public class NoticeUserServiceImp implements NoticeUserService{

	@Autowired
	private NoticeUserMapper noticeUserMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeUser> searchByNoticeId(Integer noticeId) {
		NoticeUserExample bean=new NoticeUserExample();
		bean.createCriteria().andNoticeIdEqualTo(noticeId);
		return noticeUserMapper.selectByExample(bean);
	}


	@Override
	public int insertNoticeUser(NoticeUser noticeUser) {
		// TODO Auto-generated method stub
		return noticeUserMapper.insert(noticeUser);
	}


	@Override
	public NoticeCustom searchNoticeCustomById(Integer id) {
		// TODO Auto-generated method stub
		Notice notice= noticeMapper.selectByPrimaryKey(id);
		NoticeCustom noticeCustom=new NoticeCustom();
		BeanUtils.copyProperties(notice, noticeCustom);
		List<NoticeUser>  list=this.searchByNoticeId(noticeCustom.getId());
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
		
		
		noticeCustom.setUsersId(usersId);
		noticeCustom.setUsersName(usersname);
		noticeCustom.setNum(list.size());
		return noticeCustom;
	}


	@Override
	public int deleteNoticeUserById(Integer id) {
		
		return noticeUserMapper.deleteByPrimaryKey(id);
	}


	@Override
	public int deleteNoticeUserByNoticeId(Integer noticeId) {
		NoticeUserExample bean=new NoticeUserExample();
		bean.createCriteria().andNoticeIdEqualTo(noticeId);
		return noticeUserMapper.deleteByExample(bean);
	}

}
