package com.uclibm.ixn.controller;

import com.uclibm.ixn.service.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/userInputs")
public class UserInputController {

    private UserInputService userInputService;

    @PostMapping
    public void addUserInput(String content){
        userInputService.addUserInput(content);
    }

    @GetMapping
    public Map<String, Integer> getUserReport(){
        return userInputService.getUserReport();
    }

    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

}
