package com.tmetal.springcloud.controller;

import com.tmetal.springcloud.entities.CommonResult;
import com.tmetal.springcloud.entities.ProviderPay;
import com.tmetal.springcloud.service.ProviderPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ProviderPayController {

    @Autowired
    private ProviderPayService providerPayService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public void tes() {
        System.out.println("11111111111");
    }

    @PostMapping("/providerpay/create")
    public CommonResult create(@RequestBody ProviderPay providerPay) {

        int result = providerPayService.create(providerPay);

        log.info("************输入的插入结果" + providerPay);
        return result > 0 ? new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result)
                : new CommonResult(444, "插入数据库失败,serverPort:" + serverPort, null);
    }

    @GetMapping("/providerpay/get/{id}")
    public CommonResult getProviderPayById(@PathVariable("id") Long id) {

        ProviderPay providerPay = providerPayService.getProviderPayById(id);

        log.info("************根据" + id + "查询的结果" + providerPay);
        return providerPay != null ? new CommonResult(200, "查询的结果,serverPort:" + serverPort, providerPay)
                : new CommonResult(444, "没有对应记录，查询ID" + id + "serverPort:" + serverPort, null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*********service:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }


    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
