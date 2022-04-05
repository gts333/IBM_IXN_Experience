package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.UserInputDao;
import com.uclibm.ixn.service.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserInputServiceImpl implements UserInputService {

    private UserInputDao userInputDao;

    @Override
    public void addUserInput(String string) {
        userInputDao.addContent(string);
    }

    @Override
    public Map<String, Integer> getUserReport() {
        return null;
    }

    @Autowired
    public void setUserInputDao(UserInputDao userInputDao) {
        this.userInputDao = userInputDao;
    }

}
