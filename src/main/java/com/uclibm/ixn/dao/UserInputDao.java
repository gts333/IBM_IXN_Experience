package com.uclibm.ixn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInputDao {
    /**
     * get all contents
     * @return a list of contents
     */
    List<String> getAllContents();

    /**
     * add a content
     * @return whether successfully added
     */
    Integer addContent(@Param("content") String content);
}
