package com.ibm.ixn.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private String username;
    private String password;
}
