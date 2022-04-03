package com.uclibm.ixn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping(value = "/admin.html")
    public String admin() {
        return "admin";
    }


    @RequestMapping(value = "/contact.html")
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/forum.html")
    public String forum() {
        return "forum";
    }

    @RequestMapping(value = "/homepage.html")
    public String homePage() {
        return "homepage";
    }

    @RequestMapping(value = "/industry.html")
    public String enterprise() {
        return "industry";
    }

    @RequestMapping(value = "/info.html")
    public String guide() {
        return "info";
    }

    @RequestMapping(value = "/news.html")
    public String news() {
        return "news";
    }

    @RequestMapping(value = "/privacy.html")
    public String privacy() {
        return "privacy";
    }

    @RequestMapping(value = "/projects.html")
    public String projects() {
        return "projects";
    }

    @RequestMapping(value = "/registration.html")
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/student.html")
    public String student() {
        return "student";
    }

    @RequestMapping(value = "/university.html")
    public String university() {
        return "university";
    }

}
