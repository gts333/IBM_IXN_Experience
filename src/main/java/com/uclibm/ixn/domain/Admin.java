package com.uclibm.ixn.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Admin implements Serializable {
    private String username;
    private String password;
}
