package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.domain.Project;
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
    void getAllProjects() {
        System.out.println(projectService.getAllProjects());
    }

    @Test
    void removeProjectByTitle() {
        System.out.println(projectService.removeProjectByTitle("tt"));
    }

    @Test
    void addProject() {
        Project project = new Project();
        project.setRepo("t");
        project.setContent("t");
        project.setImage("t");
        project.setTitle("t");
        System.out.println(projectService.addProject(project));
    }

    @Test
    void getProjectsByTitle() {
        System.out.println(projectService.getProjectsByTitle("t"));
    }
}