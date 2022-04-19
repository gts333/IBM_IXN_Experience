package com.uclibm.ixn.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Project implements Serializable {
    private String title;
    private String content;
    private String repo;
    private String image;
}

