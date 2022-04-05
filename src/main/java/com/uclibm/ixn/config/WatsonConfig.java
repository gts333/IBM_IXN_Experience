package com.uclibm.ixn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WatsonConfig {

    @Value("${watson.api}")
    public String api;

    @Value("${watson.url}")
    public String url;

}
