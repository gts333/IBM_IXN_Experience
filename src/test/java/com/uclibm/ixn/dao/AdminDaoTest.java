package com.uclibm.ixn.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminDaoTest {
    @Autowired
    AdminDao adminDao;

    @Test
    void getMatchCount() {
        assertEquals(adminDao.getMatchCount("test", "test"), 0);
    }
}