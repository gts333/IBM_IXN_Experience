package com.uclibm.ixn.controller;



import com.uclibm.ixn.domain.News;
import com.uclibm.ixn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private NewsService NewsService;

    @GetMapping
    public List<News> getAllNews(){
        return NewsService.getAllNews();
    }

    @PostMapping
    public String addNews(String topic, String content, String time, String image){
        News News = new News();
        News.setTitle(topic);
        News.setContent(content);
        News.setTime(time);
        News.setImage(image);
        return NewsService.addNews(News) == 1?"added successfully, there might be a delay in updating the website":"an error occurred";
    }

    @DeleteMapping
    public String deleteEntityByTitle(String title){
        return NewsService.removeNewsByTitle(title) == 1?"deleted successfully, there might be a delay in updating the website":"an error occurred";
    }

    @Autowired
    public void setNewsService(NewsService NewsService) {
        this.NewsService = NewsService;
    }





}