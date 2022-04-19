package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InfoDaoTest {
    @Autowired
    InfoDao infoDao;

    @Test
    void getAllInfos() {
        System.out.println(infoDao.getAllInfos());
    }

    @Test
    void addInfo() {
        Info info = new Info();
        info.setTopic("test");
        info.setContent("ttt");
        System.out.println(infoDao.addInfo(info));
    }

    @Test
    void deleteInfoByTopic() {
        System.out.println(infoDao.deleteInfoByTopic("test"));
    }

    @Test
    void getInfosByTopic() {
        System.out.println(infoDao.getInfosByTopic("te"));
    }
}