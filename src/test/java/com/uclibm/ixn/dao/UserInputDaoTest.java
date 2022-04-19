package com.uclibm.ixn.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInputDaoTest {
    @Autowired
    UserInputDao userInputDao;

    @Test
    void getAllContents() {
        System.out.println(userInputDao.getAllContents());
    }

    @Test
    void addContent() {
        System.out.println(userInputDao.addContent("tt"));
    }
}