package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.dao.InfoDao;
import com.uclibm.ixn.domain.Info;
import com.uclibm.ixn.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    private InfoDao infoDao;

    @Override
    public List<Info> getAllInfos() {
        return infoDao.getAllInfos();
    }

    @Override
    public Integer removeInfoByTopic(String topic) {
        return infoDao.deleteInfoByTopic(topic);
    }

    @Override
    public Integer addInfo(Info info) {
        return infoDao.addInfo(info);
    }

    @Autowired
    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

}
