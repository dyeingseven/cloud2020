package com.tmetal.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//使用ribbon的其他负载方式（使用的是irule.myrule.MySelfRule+@RibbonClent）
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
