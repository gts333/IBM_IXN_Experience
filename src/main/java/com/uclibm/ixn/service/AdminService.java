package com.uclibm.ixn.service;

import com.uclibm.ixn.domain.Post;


import java.util.List;

public interface AdminService {
    /**
     *
     * @param username the username of admin
     * @param password the password of admin
     * @return true if the record matches
     */
    Boolean adminLogin(String username, String password);


}
