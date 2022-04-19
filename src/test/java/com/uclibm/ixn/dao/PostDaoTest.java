package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostDaoTest {
    @Autowired
    PostDao postDao;

    @Test
    void addPost() {
        Post post = new Post();
        post.setName("test");
        post.setContent("test");
        post.setPostTime(new Timestamp(System.currentTimeMillis()));
        post.setTitle("tesst");
        System.out.println(postDao.addPost(post));
    }

    @Test
    void getPostCounts() {
        System.out.println(postDao.getPostCounts());
    }

    @Test
    void removePost() {
        System.out.println(postDao.removePost(3));
    }

    @Test
    void getAllPosts() {
        System.out.println(postDao.getAllPosts());
    }

    @Test
    void getRequiredRangeOfPosts() {
        System.out.println(postDao.getRequiredRangeOfPosts(0,10));
    }

    @Test
    void getPostById() {
        System.out.println(postDao.getPostById(5));
    }

    @Test
    void getPostsByTitle() {
        System.out.println(postDao.getPostsByTitle("te"));
    }
}