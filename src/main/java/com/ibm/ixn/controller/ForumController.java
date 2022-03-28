package com.ibm.ixn.controller;


import com.ibm.ixn.domain.Comment;
import com.ibm.ixn.domain.Post;
import com.ibm.ixn.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class ForumController {

    private ForumService forumService;

    //Adding a new post
    @RequestMapping(value = "/addPost.do", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(String title, String name, String content){
        Post post = new Post();
        post.setTitle(title);
        post.setName(name);
        post.setContent(content);
        post.setPostTime(new Timestamp(System.currentTimeMillis()));
        boolean result = forumService.addPost(post);
        if(result){
            return "posted successfully";
        } else {
            return "an error occurred, the error is recorded";
        }
    }

    //Get post count
    @RequestMapping(value = "/getPostsCount.do")
    @ResponseBody
    public String getPostCount(){
        return forumService.getPostCounts().toString();
    }

    //Get all posts
    @RequestMapping(value = "/getAllPosts.do")
    @ResponseBody
    public List<Post> getAllPosts(){
        return forumService.getAllPosts();
    }

    //Get required range of posts
    @RequestMapping(value = "/getRequiredPosts.do")
    @ResponseBody
    public List<Post> getRequiredPosts(String index){
        return forumService.getRequiredRangeOfPosts(Integer.parseInt(index));
    }
    //Get required posts by title
    @RequestMapping(value =  "/getPostsByTitle/{title}/.do")
    @ResponseBody
    public List<Post> getRequiredPostsByTitle(@PathVariable String title){
        return forumService.getPostsByTitle(title);
    }


    //Get required post page by post id
    @RequestMapping(value = "/getPostPage/{id}.do")
    public String getPostPage(Model model, @PathVariable int id){
        Post post = forumService.getPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    //Get required comments by post id
    @RequestMapping(value = "/getComments/{id}.do")
    @ResponseBody
    public List<Comment> getRequiredComments(@PathVariable int id){
        return forumService.getCommentsById(id);
    }

    //Add a comment
    @RequestMapping(value = "/addComment.do", method = RequestMethod.POST)
    @ResponseBody
    public String addComment(String id, String floor, String name, String content){
        Comment comment = new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setFloor(Integer.parseInt(floor));
        comment.setName(name);
        comment.setContent(content);
        comment.setPostTime(new Timestamp(System.currentTimeMillis()));
        boolean result = forumService.addComment(comment);
        if(result){
            return "posted successfully";
        } else {
            return "an error occurred, the error is recorded";
        }
    }

    @Autowired
    public void setForumService(ForumService forumService){
        this.forumService = forumService;
    }



}

