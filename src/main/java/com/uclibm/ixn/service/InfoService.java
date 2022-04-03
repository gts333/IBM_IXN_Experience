package com.uclibm.ixn.service;

import com.uclibm.ixn.domain.Info;

import java.util.List;

public interface InfoService {

    List<Info> getAllInfos();

    Integer removeInfoByTopic(String topic);

    Integer addInfo(Info info);

}
