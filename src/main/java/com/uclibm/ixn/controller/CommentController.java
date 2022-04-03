package com.uclibm.ixn.controller;

import com.uclibm.ixn.domain.Comment;
import com.uclibm.ixn.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private ForumService forumService;

    //Get required comments by post id
    @GetMapping(value = "/{id}")
    public List<Comment> getRequiredComments(@PathVariable int id){
        return forumService.getCommentsById(id);
    }

    //Add a comment
    @PostMapping
    public String addComment(String id, String floor, String name, String content){
        Comment comment = new Comment();
        comment.setId(Integer.parseInt(id));
        comment.setFloor(Integer.parseInt(floor));
        comment.setName(name);
        comment.setContent(content);
        comment.setPostTime(new Timestamp(System.currentTimeMillis()));
        boolean result = forumService.addComment(comment);
        if(result){
            return "posted successfully, there might be a delay in updating the website";
        } else {
            return "an error occurred";
        }
    }

    @DeleteMapping
    public String adminDeleteComment(String id, String floor){
        if (forumService.adminDeleteComment(Integer.parseInt(id), Integer.parseInt(floor))){
            return "comment successfully deleted, there might be a delay in updating the website";
        }else {
            return "an error occurred";
        }
    }


    @Autowired
    public void setForumService(ForumService forumService){
        this.forumService = forumService;
    }
}
