package com.uclibm.ixn.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
public class News implements Serializable {
    private String title;
    private String content;
    private String time;
    private String image;
}
