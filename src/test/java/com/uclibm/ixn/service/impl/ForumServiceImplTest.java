package com.uclibm.ixn.service.impl;


import com.uclibm.ixn.domain.Comment;
import com.uclibm.ixn.domain.Post;
import com.uclibm.ixn.service.ForumService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;


@SpringBootTest
class ForumServiceImplTest {
    @Autowired
    ForumService forumService;



    @Test
    void getPostCounts() {
        System.out.println(forumService.getPostCounts());
    }

    @Test
    void addPost() {
        Post post = new Post();
        post.setName("test");
        post.setContent("test");
        post.setPostTime(new Timestamp(System.currentTimeMillis()));
        post.setTitle("tesst");
        System.out.println(forumService.addPost(post));
    }

    @Test
    void addComment() {
        Comment comment = new Comment();
        comment.setContent("test");
        comment.setFloor(1);
        comment.setId(19);
        comment.setName("tst");
        comment.setPostTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(forumService.addComment(comment));

    }

    @Test
    void getPostsByTitle() {
        System.out.println(forumService.getPostsByTitle("t"));

    }

    @Test
    void getAllPosts() {
        System.out.println(forumService.getAllPosts());
    }

    @Test
    void getRequiredRangeOfPosts() {
        System.out.println(forumService.getRequiredRangeOfPosts(1));
    }

    @Test
    void getCommentsById() {
        System.out.println(forumService.getCommentsById(5));
    }

    @Test
    void getPostById() {
        System.out.println(forumService.getPostById(12));
    }

    @Test
    void deletePostById() {
        System.out.println(forumService.deletePostById(15));
    }

    @Test
    void deleteCommentById() {
        System.out.println(forumService.deleteCommentById(15,1));
    }

    @Test
    void adminDeletePostById() {
        System.out.println(forumService.adminDeletePostById(5));
    }

    @Test
    void adminDeleteComment() {
        System.out.println(forumService.adminDeleteComment(15,1));
    }
}