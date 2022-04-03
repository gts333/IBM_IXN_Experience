package com.uclibm.ixn.service;

import com.uclibm.ixn.domain.Comment;
import com.uclibm.ixn.domain.Post;


import java.util.List;

public interface ForumService {
    /**
     *
     * @return the total number of posts
     */
    Integer getPostCounts();
    /**
     *
     * @param post the post to be added
     * @return whether the post is added successfully
     */
    Boolean addPost(Post post);

    /**
     *
     * @param comment the comment to be added
     * @return whether the comment is added successfully
     */
    Boolean addComment(Comment comment);

    /**
     *
     * @param title title or part of the title of a post
     * @return the posts
     */
    List<Post> getPostsByTitle(String title);

    /**
     *
     * @return a list of all the posts
     */
    List<Post> getAllPosts();

    /**
     *
     * @param index the index required by the browser
     * @return posts in required range
     * the first post is order 0
     * for example, index = 2 means loading posts in range 10-19
     */
    List<Post> getRequiredRangeOfPosts(Integer index);
    /**
     *
     * @param id the id of the post
     * @return all the comments on that post ordered by floor
     */
    List<Comment> getCommentsById(Integer id);

    /**
     *
     * @param id the id of the post
     * @return the required post
     */
    Post getPostById(Integer id);
    /**
     *
     * @param id the id of the post
     * @return whether successfully deleted
     */
    Boolean deletePostById(Integer id);

    /**
     *
     * @param id the postId of the comment
     * @param floor the floor of the comment
     * @return whether successfully deleted
     */
    Boolean deleteCommentById(Integer id, Integer floor);


    /**
     * delete the post along with all the comments
     * @param id the id of the post
     * @return whether successfully deleted
     */
    Boolean adminDeletePostById(Integer id);

    /**
     *
     * @param id the id of the post
     * @param floor the floor of the comment
     * @return whether successfully deleted
     */
    Boolean adminDeleteComment(Integer id, Integer floor);

}
