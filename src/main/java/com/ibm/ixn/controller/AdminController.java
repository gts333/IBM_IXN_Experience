package com.ibm.ixn.controller;

import com.ibm.ixn.domain.Post;
import com.ibm.ixn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    
    private AdminService adminService;

    @RequestMapping("/adminLogin.do")
    public ModelAndView adminLogin(String username, String password){
        Boolean matches = adminService.adminLogin(username, password);
        if(matches){
            ModelAndView modelAndView = new ModelAndView("adminPortal");
            modelAndView.addObject("adminName", username);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("admin");
            modelAndView.addObject("invalid", "invalid");
            return modelAndView;
        }
    }

    @RequestMapping("/adminSearchPostsByTitle/{title}.do")
    @ResponseBody
    public List<Post> adminGetPostsByTitle(@PathVariable("title")String title){
        return adminService.adminGetPostsByTitle(title);
    }

    @RequestMapping("/adminDeletePost/{id}.do")
    @ResponseBody
    public String adminDeletePostsAndCommentsById(@PathVariable("id")String id){
        if(adminService.adminDeletePostById(Integer.parseInt(id))){
            return "post successfully deleted";
        }else {
            return "an error occurred, this is recorded";
        }
    }

    @RequestMapping("/adminDeleteComment.do")
    @ResponseBody
    public String adminDeleteComment(String id, String floor){
        if (adminService.adminDeleteComment(Integer.parseInt(id), Integer.parseInt(floor))){
            return "comment successfully deleted";
        }else {
            return "an error occurred, this is recorded";
        }
    }
    
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    
}
