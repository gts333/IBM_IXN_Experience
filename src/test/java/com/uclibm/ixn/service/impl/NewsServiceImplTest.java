package com.uclibm.ixn.service.impl;

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
    void getNewsByTopic() {
        System.out.println(newsService.getNewsByTopic("passage"));
    }
}