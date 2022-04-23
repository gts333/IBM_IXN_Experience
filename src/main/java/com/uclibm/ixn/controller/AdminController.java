package com.uclibm.ixn.controller;

import com.uclibm.ixn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;

    @PostMapping
    public String adminLogin(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean matches = adminService.adminLogin(username, password);
        if(matches){
            model.addAttribute("adminName", username);
            return "adminPortal";
        }else{
            model.addAttribute("invalid", "invalid");
            return "admin";
        }
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

}
