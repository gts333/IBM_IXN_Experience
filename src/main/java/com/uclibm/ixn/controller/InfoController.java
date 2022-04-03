package com.uclibm.ixn.controller;

import com.uclibm.ixn.domain.Info;
import com.uclibm.ixn.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infos")
public class InfoController {

    private InfoService infoService;

    @GetMapping
    public List<Info> getAllInfos(){
        return infoService.getAllInfos();
    }

    @PostMapping
    public String addInfo(String topic, String content){
        Info info = new Info();
        info.setTopic(topic);
        info.setContent(content);
        return infoService.addInfo(info) == 1?"added successfully, there might be a delay in updating the website":"an error occurred";
    }

    @DeleteMapping
    public String deleteEntityByTopic(String topic){
        return infoService.removeInfoByTopic(topic) == 1?"deleted successfully, there might be a delay in updating the website":"an error occurred";
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

}
