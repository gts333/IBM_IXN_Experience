package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;


    @Test
    void adminLogin() {
        //The method had been tested with the real username and password, they are not displayed to avoid data leak
        assertEquals(adminService.adminLogin("test", "test"), false);
    }
}