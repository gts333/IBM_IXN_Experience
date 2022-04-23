package com.uclibm.ixn.controller;

import com.uclibm.ixn.domain.Post;
import com.uclibm.ixn.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private ForumService forumService;

    //Get all posts
    @GetMapping
    public List<Post> getAllPosts(){
        return forumService.getAllPosts();
    }

    //Get required range of posts
    @GetMapping(value = "/requiredRange")
    public List<Post> getRequiredPosts(String index){
        return forumService.getRequiredRangeOfPosts(Integer.parseInt(index));
    }

    //Get post count
    @GetMapping(value = "/count")
    public String getPostCount(){
        return forumService.getPostCounts().toString();
    }

    //Get required posts by title
    @GetMapping(value =  "/byTitle/{title}")
    public List<Post> getRequiredPostsByTitle(@PathVariable String title){
        return forumService.getPostsByTitle(title);
    }

    //Get required post page by post id
    @RequestMapping(value = "/getPage/{id}")
    public ModelAndView getPostPage(@PathVariable int id){
        Post post = forumService.getPostById(id);
        ModelAndView modelAndView = new ModelAndView("post");
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    //Adding a new post
    @PostMapping
    public String addPost(String title, String name, String content){
        Post post = new Post();
        post.setTitle(title);
        post.setName(name);
        post.setContent(content);
        post.setPostTime(new Timestamp(System.currentTimeMillis()));
        boolean result = forumService.addPost(post);
        if(result){
            return "posted successfully, there might be a delay in updating the website";
        } else {
            return "an error occurred";
        }
    }

    //deleting a post
    @DeleteMapping("/{id}")
    public String adminDeletePostsAndCommentsById(@PathVariable String id){
        if(forumService.adminDeletePostById(Integer.parseInt(id))){
            return "post successfully deleted, there might be a delay in updating the website";
        }else {
            return "an error occurred";
        }
    }

    @Autowired
    public void setForumService(ForumService forumService){
        this.forumService = forumService;
    }

}

