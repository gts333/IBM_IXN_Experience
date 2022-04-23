package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostDao {
    /**
     *
     * @param post the post to be added
     * @return the number of lines affected
     */
    Integer addPost(Post post);

    /**
     *
     * @return the total number of posts
     */
    Integer getPostCounts();

    /**
     *
     * @param id the id of the post
     * @return the number of lines affected
     */
    Integer removePost(Integer id);

    /**
     *
     * @return a list of all posts
     */
    List<Post> getAllPosts();

    /**
     *
     * @param begin the begin index
     * @param step the step length
     * @return posts in required range
     * for example, begin = 0 and step = 10 indicates the first 10 records
     */
    List<Post> getRequiredRangeOfPosts(@Param("begin") Integer begin, @Param("step") Integer step);

    /**
     *
     * @param id the id of the post
     * @return the post
     */
    Post getPostById(Integer id);

    /**
     *
     * @param title the title (or part of the title)
     * @return the post
     */
    List<Post> getPostsByTitle(@Param("title") String title);

}
