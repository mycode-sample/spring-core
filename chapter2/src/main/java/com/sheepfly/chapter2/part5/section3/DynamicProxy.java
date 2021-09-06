package com.sheepfly.chapter2.part5.section3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicProxy {
    private static final Logger log = LoggerFactory.getLogger(DynamicProxy.class);

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Service serviceProxy = ServiceProxy.getServiceProxy(service);
        serviceProxy.createCompany();
        Service simpleServiceProxy = ServiceProxy.getSimpleServiceProxy(service);
        simpleServiceProxy.createCompany();
    }
}
