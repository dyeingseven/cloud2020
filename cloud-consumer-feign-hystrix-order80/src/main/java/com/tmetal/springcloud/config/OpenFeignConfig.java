package com.tmetal.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level openFeignConfigLevel(){
        return Logger.Level.FULL;
    }
}
