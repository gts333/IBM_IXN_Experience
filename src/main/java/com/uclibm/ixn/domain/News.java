package com.uclibm.ixn.domain;

import lombok.Data;



import java.sql.Timestamp;


@Data
public class News {
    private String title;
    private String content;
    private Timestamp time;
    private String image;
}
