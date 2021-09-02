package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceProxy implements SuperService {
    private static Logger log = LoggerFactory.getLogger(ServiceProxy.class);
    private SuperService superService;

    public ServiceProxy(SuperService superService) {
        this.superService = superService;
    }

    @Override
    public void createCompany() {
        log.info("开始检查创建公司的文件");
        superService.createCompany();
        log.info("公司创建完成，开始做宣传工作");
    }
}
