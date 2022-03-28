package com.uclibm.ixn.service;

import com.uclibm.ixn.domain.Post;


import java.util.List;

public interface AdminService {
    /**
     *
     * @param username the username of admin
     * @param password the password of admin
     * @return true if the record matches
     */
    Boolean adminLogin(String username, String password);
    /**
     *
     * @param title title or part of the title of a post
     * @return the posts
     */
    List<Post> adminGetPostsByTitle(String title);

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
