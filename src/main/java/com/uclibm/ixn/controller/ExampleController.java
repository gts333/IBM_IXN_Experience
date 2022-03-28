package com.uclibm.ixn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExampleController {

    @RequestMapping("/example")
    public String index(Model model){
        model.addAttribute("title", "the title passed from backend");
        return "example";
    }

}