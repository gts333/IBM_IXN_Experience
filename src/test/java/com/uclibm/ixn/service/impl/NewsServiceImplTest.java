package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.domain.News;
import com.uclibm.ixn.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NewsServiceImplTest {
    @Autowired
    NewsService newsService;

    @Test
    void getAllNews() {
        System.out.println(newsService.getAllNews());
    }

    @Test
    void removeNewsByTitle() {
        System.out.println(newsService.removeNewsByTitle("t"));
    }

    @Test
    void addNews() {
        News news = new News();
        news.setTime("tesst");
        news.setImage("t");
        news.setTitle("t");
        news.setContent("47");
        System.out.println(newsService.addNews(news));
    }

    @Test
    void getNewsByTopic() {
        System.out.println(newsService.getNewsByTopic("te"));
    }
}