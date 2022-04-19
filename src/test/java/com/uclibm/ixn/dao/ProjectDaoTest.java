package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectDaoTest {
    @Autowired
    ProjectDao projectDao;

    @Test
    void getAllProjects() {
        System.out.println(projectDao.getAllProjects());
    }

    @Test
    void addProject() {
        Project project = new Project();
        project.setRepo("t");
        project.setContent("t");
        project.setImage("t");
        project.setTitle("t");
        System.out.println(projectDao.addProject(project));
    }

    @Test
    void deleteProjectByTitle() {
        System.out.println(projectDao.deleteProjectByTitle("t"));
    }

    @Test
    void getProjectsByTopic() {
        System.out.println(projectDao.getProjectsByTopic("t"));
    }
}