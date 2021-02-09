package com.tmetal.ribbon.irule.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * ribbon 的 负载机制Irule 的调用
 * @author PC
 * 注意：不能再@ComponentScan包扫描下
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
