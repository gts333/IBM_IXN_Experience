package com.uclibm.ixn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {
    /**
     *
     * @param username the admin username
     * @param password the admin password
     * @return the number of results found in the database
     */
    Integer getMatchCount(@Param("username") String username, @Param("password") String password);
}
