package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {
    /**
     *
     * @param comment the comment to be added
     * @return the number of rows affected in the database
     */
    Integer addComment(Comment comment);

    /**
     *
     * @param id the id of the post
     * @param floor the floor of the comment
     * @return the number of rows affected in the database
     */
    Integer removeComment(@Param("id") Integer id, @Param("floor") Integer floor);

    /**
     * delete all the comments of a blog
     * @param id the id of the post
     */
    void removeAllCommentsById(Integer id);

    /**
     *
     * @param id the id of the post
     * @return the number of comments with that id
     */
    Integer getCommentCountsById(Integer id);

    /**
     *
     * @param id the id of the post
     * @return the list of comments in that post, ordered by floor
     */
    List<Comment> getAllCommentsById(Integer id);
}
