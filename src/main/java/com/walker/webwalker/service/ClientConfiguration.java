package com.walker.webwalker.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service("config")
public class ClientConfiguration {

    @Value("${host.url}")
    private String hostUrl = "";
    @Value("${client.agent}")
    private String agent = "Chrome";
    @Value("${client.timeout}")
    private int timeout = 5000;
    @Value("${client.cookie}")
    private String cookie = "value123";
    @Value("${client.refferer}")
    private String refferer = "http://google.com";
    @Value("${client.header}")
    private String header = "xyz123";
}
