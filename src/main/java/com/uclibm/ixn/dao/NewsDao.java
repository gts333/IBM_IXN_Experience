package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsDao {
    /**
     * get all news
     * @return a list of news
     */
    List<News> getAllNews();

    /**
     * add a news
     * @return whether successfully added
     */
    Integer addNews(News news);

    /**
     * delete a news by title
     * @return whether successfully deleted
     */
    Integer deleteNewsByTitle(@Param("title")String title);

    List<News> getNewsByTopic(@Param("topic")String topic);


}
