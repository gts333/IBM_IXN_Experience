package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.AdminDao;
import com.uclibm.ixn.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    /**
     * @inheritDoc
     */
    @Override
    public Boolean adminLogin(String username, String password) {
        return adminDao.getMatchCount(username, password) == 1;
    }


    @Autowired
    public void setAdminDao(AdminDao adminDao){
        this.adminDao = adminDao;
    }


}
