package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectServiceImplTest {
    @Autowired
    ProjectService projectService;

    @Test
    void getProjectsByTitle() {
        System.out.println(projectService.getProjectsByTitle("Wat"));
    }
}