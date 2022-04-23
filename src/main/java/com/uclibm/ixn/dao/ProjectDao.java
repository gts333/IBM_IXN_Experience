package com.uclibm.ixn.dao;

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

    /**
     * get projects by its topic
     * @param topic the topic to be searched
     * @return a list of Projects whose topic contain the searched topic
     */
    List<Project> getProjectsByTopic(@Param("topic")String topic);
}
