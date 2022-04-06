package com.uclibm.ixn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {
    @RequestMapping("/error/{status}")
    public String errorPage(@PathVariable Integer status){
        switch (status){
            case 404:return "/error/404";
            case 500:return "/error/500";
            default:return "/error/default";
        }
    }
}
