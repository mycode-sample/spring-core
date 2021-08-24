package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Proxy {
    private static final Logger log = LoggerFactory.getLogger(Proxy.class);

    private Service service;

    public Proxy() {
    }

    public Proxy(Service service) {
        this.service = service;
    }

    public void createCompany() {
        this.service.createCompany();
    }
}
