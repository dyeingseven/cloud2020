package com.tmetal.springcloud.controller;

import com.tmetal.springcloud.entities.CommonResult;
import com.tmetal.springcloud.entities.ProviderPay;
import com.tmetal.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT8001_URL = "http://localhost:8001";
    public static final String PAYMENT8001_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLoadBalancer myLoadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * consumer client calls service clinet(clinet calls server)
     *
     * @param providerPay
     * @return
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<ProviderPay> create(ProviderPay providerPay) {
        return restTemplate.postForObject(PAYMENT8001_URL + "/providerpay/create",
                providerPay, CommonResult.class);
    }

    /**
     * get ProviderPay entities by id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<ProviderPay> getProviderPay(@PathVariable("id") Long id) {
        //commonResult封装通过id查询出来的ProviderPay对象
        CommonResult commonResult =
                restTemplate.getForObject(PAYMENT8001_URL + "/providerpay/get/" + id, CommonResult.class);
        return commonResult;

    }

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<ProviderPay> getProviderPay1(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity =
                restTemplate.getForEntity(PAYMENT8001_URL + "/providerpay/get/" + id, CommonResult.class);

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            //**************
            log.info(String.valueOf(forEntity.getStatusCode()));
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }


    @GetMapping(value = "/consumer/payment/myloadbalancer")
    public String getPaymentByMyLoadBalancer() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (null == instances || instances.size() < 0) {
            return null;
        }

        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        System.out.println("获取服务名称:" + serviceInstance.getServiceId() + "(" + serviceInstance.getInstanceId() + ")"
                + "的uri:" + serviceInstance.getUri());
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }
}
