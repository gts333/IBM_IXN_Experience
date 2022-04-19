package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NewsDaoTest {
    @Autowired
    NewsDao newsDao;

    @Test
    void getAllNews() {
        System.out.println(newsDao.getAllNews());
    }

    @Test
    void addNews() {
        News news = new News();
        news.setTime("tesst");
        news.setImage("t");
        news.setTitle("t");
        news.setContent("47");
        System.out.println(newsDao.addNews(news));
    }

    @Test
    void deleteNewsByTitle() {
        System.out.println(newsDao.deleteNewsByTitle("t"));
    }

    @Test
    void getNewsByTopic() {
        System.out.println(newsDao.getNewsByTopic("t"));
    }
}