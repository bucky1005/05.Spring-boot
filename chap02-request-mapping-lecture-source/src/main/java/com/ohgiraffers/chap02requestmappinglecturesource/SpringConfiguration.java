package com.ohgiraffers.chap02requestmappinglecturesource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Value("${server.port}")
    public int port;

    @Bean
    public Object propertyRead() {
        System.out.println("port = " + port);

        return new Object();
    }
}
