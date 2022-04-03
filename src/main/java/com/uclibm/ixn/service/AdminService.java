package com.uclibm.ixn.service;


public interface AdminService {
    /**
     *
     * @param username the username of admin
     * @param password the password of admin
     * @return true if the record matches
     */
    Boolean adminLogin(String username, String password);


}
