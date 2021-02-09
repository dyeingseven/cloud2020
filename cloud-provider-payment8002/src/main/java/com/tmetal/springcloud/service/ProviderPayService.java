package com.tmetal.springcloud.service;

import com.tmetal.springcloud.entities.ProviderPay;

public interface ProviderPayService {

    int create(ProviderPay providerPay);

    ProviderPay getProviderPayById(Long id);
}
