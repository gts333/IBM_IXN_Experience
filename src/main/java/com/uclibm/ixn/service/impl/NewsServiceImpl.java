package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.NewsDao;
import com.uclibm.ixn.domain.News;
import com.uclibm.ixn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;
    @Override
    public List<News> getAllNews() {
        return newsDao.getAllNews();
    }

    @Override
    public Integer removeNewsByTitle(String title) {
        return newsDao.deleteNewsByTitle(title);
    }

    @Override
    public Integer addNews(News news) {
        return newsDao.addNews(news);
    }

    @Autowired
    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

}
