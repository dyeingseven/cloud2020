package com.tmetal.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author PC
 *
 *
 */
public interface MyLoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
