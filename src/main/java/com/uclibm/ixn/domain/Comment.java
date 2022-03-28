package com.uclibm.ixn.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Comment implements Serializable {
    private Integer id;
    private Integer floor;
    private String name;
    private String content;
    private Timestamp postTime;
}
