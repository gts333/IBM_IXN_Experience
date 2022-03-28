package com.uclibm.ixn.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Post implements Serializable {
    private Integer id;
    private String name;
    private String title;
    private String content;
    private Timestamp postTime;
}
