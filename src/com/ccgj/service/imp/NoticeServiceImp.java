package com.ccgj.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.Notice;
import com.ccgj.database.beans.NoticeExample;
import com.ccgj.database.beans.NoticeUser;
import com.ccgj.database.custom.beans.NoticeCustom;
import com.ccgj.database.custom.mapper.NoticeCustomMapper;
import com.ccgj.database.mapper.NoticeMapper;
import com.ccgj.database.mapper.NoticeUserMapper;
import com.ccgj.service.inter.NoticeService;
import com.github.pagehelper.PageHelper;

public class NoticeServiceImp implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;
   
    @Autowired
    private NoticeCustomMapper noticeCustomMapper;
	@Override
	public CommonPage<NoticeCustom> searchNewsByTitleAndDateListWithPage(
			String title, Date startDate, Date endDate, Integer pageNum) {
		
		if(title!=null&&title.length()>0)title="%"+title+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<NoticeCustom> list = noticeCustomMapper.selectByTitleAndDate(title,
				startDate, endDate);
		return (CommonPage<NoticeCustom>) BeanUtil.toPagedResult(list);
	}
	@Override
	public int insertNotice(Notice notice) {
		
		return noticeMapper.insert(notice);
	}
	@Override
	public List<Notice> searchByBeans(Notice notice) {
		NoticeExample bean=new NoticeExample();
		NoticeExample.Criteria criteria= bean.createCriteria();
		if(notice.getId()!=null&&notice.getId()>0){
			criteria.andIdEqualTo(notice.getId());
		}if(notice.getTitle()!=null&&notice.getTitle().length()>0){
			criteria.andTitleEqualTo(notice.getTitle());
		}if(notice.getContent()!=null&&notice.getContent().length()>0){
			criteria.andContentEqualTo(notice.getContent());
		}if(notice.getCreateuser()!=null&&notice.getCreateuser()>0){
			criteria.andCreateuserEqualTo(notice.getCreateuser());
		}if(notice.getCreatename()!=null&&notice.getCreatename().length()>0){
			criteria.andCreatenameEqualTo(notice.getCreatename());
		}if(notice.getCreatedate()!=null){
			criteria.andCreatedateEqualTo(notice.getCreatedate());
		}if(notice.getState()!=null&&notice.getState()>0){
			criteria.andStateEqualTo(notice.getState());
		}
		return noticeMapper.selectByExample(bean);
	}
	@Override
	public Notice searchNoticeById(Integer id) {
		
		return noticeMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateNoticeById(Integer id, Notice notice) {
		notice.setId(id);
		return noticeMapper.updateByPrimaryKeySelective(notice);
	}
	@Override
	public int deleteNoticeById(Integer id) {
		
		return noticeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public CommonPage<NoticeCustom> searchNewsByTitleAndDateAndUserIdWithPage(
			Integer userId, String title, Date startDate, Date endDate,
			Integer pageNum) {
		
		if(title!=null&&title.length()>0)title="%"+title+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<NoticeCustom> list = noticeCustomMapper.selectByTitleAndDateAndUserId(userId,title,
				startDate, endDate);
		return (CommonPage<NoticeCustom>) BeanUtil.toPagedResult(list);
	}
	@Override
	public List<NoticeCustom> searchNewsByTitleAndDateAndUserId(Integer userId,
			String title, Date startDate, Date endDate) {

		if(title!=null&&title.length()>0)title="%"+title+"%";
		
		List<NoticeCustom> list = noticeCustomMapper.selectByTitleAndDateAndUserId(userId,title,
				startDate, endDate);
		return list;
	}


}
