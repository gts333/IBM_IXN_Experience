package com.uclibm.ixn.service;

import com.uclibm.ixn.domain.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    Integer removeProjectByTitle(String title);

    Integer addProject(Project project);
}
