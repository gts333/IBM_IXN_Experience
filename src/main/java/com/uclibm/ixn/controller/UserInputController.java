package com.uclibm.ixn.controller;

import com.uclibm.ixn.service.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInputs")
public class UserInputController {

    private UserInputService userInputService;

    @PostMapping
    public void addUserInput(String content){
        userInputService.addUserInput(content);
    }

    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

}
