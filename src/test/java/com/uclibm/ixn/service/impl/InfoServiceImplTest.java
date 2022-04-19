package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.domain.Info;
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
    void getAllInfos() {
        System.out.println(infoService.getAllInfos());
    }

    @Test
    void removeInfoByTopic() {
        System.out.println(infoService.removeInfoByTopic("t"));
    }

    @Test
    void addInfo() {
        Info info = new Info();
        info.setTopic("test");
        info.setContent("ttt");
        System.out.println(infoService.addInfo(info));
    }

    @Test
    void searchInfosByTopic() {
        System.out.println(infoService.searchInfosByTopic("t"));
    }
}