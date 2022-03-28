package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.AdminDao;
import com.uclibm.ixn.dao.CommentDao;
import com.uclibm.ixn.dao.PostDao;
import com.uclibm.ixn.domain.Post;
import com.uclibm.ixn.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;
    private PostDao postDao;
    private CommentDao commentDao;

    /**
     * @inheritDoc
     */
    @Override
    public Boolean adminLogin(String username, String password) {
        return adminDao.getMatchCount(username, password) == 1;
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<Post> adminGetPostsByTitle(String title){
        return postDao.getPostsByTitle(title);
    }

    /**
     * @inheritDoc
     * NOTICE: the comments along with the posts shall be deleted
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public Boolean adminDeletePostById(Integer id){
        Integer commentCounts = commentDao.getCommentCountsById(id);
        if(commentCounts >= 0){
            commentDao.removeAllCommentsById(id);
        }
        postDao.removePost(id);
        return true;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Boolean adminDeleteComment(Integer id, Integer floor) {
        return commentDao.removeComment(id, floor) == 1;
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao){
        this.adminDao = adminDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Autowired
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }
}
