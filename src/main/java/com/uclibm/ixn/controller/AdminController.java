package com.uclibm.ixn.controller;

import com.uclibm.ixn.domain.Post;
import com.uclibm.ixn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    private AdminService adminService;

    @RequestMapping("/adminLogin.do")
    public String adminLogin(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean matches = adminService.adminLogin(username, password);
        if(matches){
//            ModelAndView modelAndView = new ModelAndView("adminPortal");
//            modelAndView.addObject("adminName", username);
//            return modelAndView;
            model.addAttribute("adminName", username);
            return "adminPortal";
        }else{
//            ModelAndView modelAndView = new ModelAndView("admin");
//            modelAndView.addObject("invalid", "invalid");
//            return modelAndView;
            model.addAttribute("invalid", "invalid");
            return "admin";
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
