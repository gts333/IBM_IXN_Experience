package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.service.InfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InfoServiceImplTest {

    @Autowired
    InfoService infoService;

    @Test
    void searchInfosByTopic() {
        System.out.println(infoService.searchInfosByTopic("es"));
    }
}