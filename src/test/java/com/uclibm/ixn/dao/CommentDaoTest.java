package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentDaoTest {
    @Autowired
    CommentDao commentDao;

    @Test
    void addComment() {
        Comment comment = new Comment();
        comment.setContent("test");
        comment.setFloor(1);
        comment.setId(19);
        comment.setName("tst");
        comment.setPostTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(commentDao.addComment(comment));
    }

    @Test
    void removeComment() {
        System.out.println(commentDao.removeComment(3, 1));
    }

    @Test
    void removeAllCommentsById() {
        commentDao.removeAllCommentsById(14);
    }

    @Test
    void getCommentCountsById() {
        System.out.println(commentDao.getCommentCountsById(15));
    }

    @Test
    void getAllCommentsById() {
        System.out.println(commentDao.getAllCommentsById(15));
    }
}