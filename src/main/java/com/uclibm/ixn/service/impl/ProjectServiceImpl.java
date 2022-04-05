package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.ProjectDao;
import com.uclibm.ixn.domain.Project;
import com.uclibm.ixn.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;
    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public Integer removeProjectByTitle(String title) {
        return projectDao.deleteProjectByTitle(title);
    }

    @Override
    public Integer addProject(Project project) {
        return projectDao.addProject(project);
    }

    @Override
    public List<Project> getProjectsByTitle(String topic) {
        return projectDao.getProjectsByTopic(topic);
    }

    @Autowired
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
}
