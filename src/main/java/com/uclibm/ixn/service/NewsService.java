package com.uclibm.ixn.service;


import com.uclibm.ixn.domain.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();

    Integer removeNewsByTitle(String title);

    Integer addNews(News news);

    List<News> getNewsByTopic(String topic);
}
