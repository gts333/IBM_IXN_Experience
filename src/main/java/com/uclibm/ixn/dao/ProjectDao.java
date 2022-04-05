package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.News;
import com.uclibm.ixn.domain.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectDao {
    /**
     * get all projects
     * @return a list of projects
     */
    List<Project> getAllProjects();

    /**
     * add a project
     * @return whether successfully added
     */
    Integer addProject(Project project);

    /**
     * delete a project by title
     * @return whether successfully deleted
     */
    Integer deleteProjectByTitle(@Param("title")String title);

    List<Project> getProjectsByTopic(@Param("topic")String topic);


}
