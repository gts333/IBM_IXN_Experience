package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.service.UserInputService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInputServiceImplTest {
    @Autowired
    UserInputService userInputService;

    @Test
    void addUserInput() {
        userInputService.addUserInput("test");
    }

    @Test
    void getUserReport() {
        System.out.println(userInputService.getUserReport());
    }
}