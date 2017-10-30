package com.ccgj.service.inter;

import java.util.Date;
import java.util.List;

import com.base.controller.common.CommonPage;
import com.ccgj.database.beans.News;

public interface NewsService {
   public CommonPage<News> searchNewsByTitleAndDateListWithPage(String title,Date startDate,Date endDate,Integer pageNum,Integer state);
   
   public List<News> searchNewsByTitleAndDateList(String title,Date startDate,Date endDate,Integer state);
   public int insertNews(News news);
   public News searchNewsById(Integer id);
   public int updateNewsById(Integer id,News news);
   public int deleteNewsById(Integer id);
}
