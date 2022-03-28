package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.CommentDao;
import com.uclibm.ixn.dao.PostDao;
import com.uclibm.ixn.domain.Comment;
import com.uclibm.ixn.domain.Post;
import com.uclibm.ixn.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    private CommentDao commentDao;
    private PostDao postDao;

    /**
     * @inheritDoc
     */
    @Override
    public Integer getPostCounts(){
        return postDao.getPostCounts();
    }
    /**
     * @inheritDoc
     */
    @Override
    public Boolean addPost(Post post){
        return postDao.addPost(post) == 1;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Boolean addComment(Comment comment){
        return commentDao.addComment(comment) == 1;
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<Post> getPostsByTitle(String title) {
        return postDao.getPostsByTitle(title);
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<Post> getAllPosts(){
        return postDao.getAllPosts();
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<Post> getRequiredRangeOfPosts(Integer index){
        Integer begin = (index - 1) * 10;
        return postDao.getRequiredRangeOfPosts(begin, 10);
    }

    /**
     *
     * @inheritDoc
     */
    @Override
    public List<Comment> getCommentsById(Integer id){
        return commentDao.getAllCommentsById(id);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Post getPostById(Integer id){
        return postDao.getPostById(id);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Boolean deletePostById(Integer id) {
        return postDao.removePost(id) == 1;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Boolean deleteCommentById(Integer id, Integer floor) {
        return commentDao.removeComment(id, floor) == 1;
    }



    @Autowired
    public void setCommentDao(CommentDao commentDao){
        this.commentDao = commentDao;
    }
    @Autowired
    public void setPostDao(PostDao postDao){
        this.postDao = postDao;
    }
}
