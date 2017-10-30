package com.ccgj.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.controller.common.BeanUtil;
import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.News;
import com.ccgj.database.beans.Systemlog;
import com.ccgj.database.custom.mapper.NewsCustomMapper;
import com.ccgj.database.mapper.NewsMapper;
import com.ccgj.service.inter.NewsService;
import com.github.pagehelper.PageHelper;

public class NewsServiceImp implements NewsService {
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private NewsCustomMapper newsCustomMapper;

	@Override
	public CommonPage<News> searchNewsByTitleAndDateListWithPage(String title,
			Date startDate, Date endDate, Integer pageNum,Integer state) {
		
		if(title!=null&&title.length()>0)title="%"+title+"%";
		pageNum = pageNum == null ? 1 : pageNum;
		
		int pageSize = 3;
		PageHelper.startPage(pageNum, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		List<News> list = newsCustomMapper.selectByTitleAndDate(title,
				startDate, endDate,state);
		return (CommonPage<News>) BeanUtil.toPagedResult(list);

	}
	@Override
	public List<News> searchNewsByTitleAndDateList(String title,
			Date startDate, Date endDate, Integer state) {
		if(title!=null&&title.length()>0)title="%"+title+"%";
		List<News> list = newsCustomMapper.selectByTitleAndDate(title,
				startDate, endDate,state);
		return list;
	}

	@Override
	public int insertNews(News news) {
		
		return newsMapper.insert(news);
	}

	@Override
	public News searchNewsById(Integer id) {
		
		return newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateNewsById(Integer id, News news) {
		news.setId(id);
		return newsMapper.updateByPrimaryKey(news);
	}

	@Override
	public int deleteNewsById(Integer id) {
	
		return newsMapper.deleteByPrimaryKey(id);
	}

	

	

}
