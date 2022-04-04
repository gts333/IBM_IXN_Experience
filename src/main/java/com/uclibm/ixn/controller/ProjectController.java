package com.uclibm.ixn.controller;

import com.uclibm.ixn.domain.Project;
import com.uclibm.ixn.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService ProjectService;

    @GetMapping
    public List<Project> getAllProjects(){
        return ProjectService.getAllProjects();
    }

    @PostMapping
    public String addProject(String topic, String content, String repo, String image){
        Project Project = new Project();
        Project.setTitle(topic);
        Project.setContent(content);
        Project.setRepo(repo);
        Project.setImage(image);
        return ProjectService.addProject(Project) == 1?"added successfully, there might be a delay in updating the website":"an error occurred";
    }

    @DeleteMapping
    public String deleteEntityByTitle(String title){
        return ProjectService.removeProjectByTitle(title) == 1?"deleted successfully, there might be a delay in updating the website":"an error occurred";
    }

    @Autowired
    public void setProjectService(ProjectService ProjectService) {
        this.ProjectService = ProjectService;
    }

}
