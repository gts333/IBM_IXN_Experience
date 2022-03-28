package com.ibm.ixn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class IxnApplication {

    public static void main(String[] args) {
        SpringApplication.run(IxnApplication.class, args);
    }

}
