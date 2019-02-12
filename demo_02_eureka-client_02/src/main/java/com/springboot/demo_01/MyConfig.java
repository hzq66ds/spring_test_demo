package com.springboot.demo_01;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "my")
public class MyConfig {
    private List<String> servers = new ArrayList<>();

    public List<String> getServers() {
        return this.servers;
    }
}
