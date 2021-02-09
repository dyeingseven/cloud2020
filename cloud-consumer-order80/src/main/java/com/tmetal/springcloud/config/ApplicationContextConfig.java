package com.tmetal.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    //默认的轮询负载方式
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

