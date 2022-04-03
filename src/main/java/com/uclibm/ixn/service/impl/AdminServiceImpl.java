package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.AdminDao;
import com.uclibm.ixn.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
