package com.uclibm.ixn.dao;

import com.uclibm.ixn.domain.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InfoDao {
    /**
     * get all info entities
     * @return a list of info entities
     */
    List<Info> getAllInfos();

    /**
     * add a info
     * @return whether successfully added
     */
    Integer addInfo(Info info);

    /**
     * delete a info by topic
     * @return whether successfully deleted
     */
    Integer deleteInfoByTopic(@Param("topic")String topic);


}
