package com.tmetal.springcloud.service.impl;


import com.tmetal.springcloud.dao.ProviderPayDao;
import com.tmetal.springcloud.entities.ProviderPay;
import com.tmetal.springcloud.service.ProviderPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProviderPayServiceImpl implements ProviderPayService {

    @Autowired
    private ProviderPayDao providerPayDao;

    @Override
    public int create(ProviderPay providerPay) {

        return providerPayDao.create(providerPay);
    }

    @Override
    public ProviderPay getProviderPayById(Long id) {

        return providerPayDao.getProviderPayById(id);
    }
}
