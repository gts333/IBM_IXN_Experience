package com.uclibm.ixn.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Info implements Serializable {
    private String topic;
    private String content;
}
