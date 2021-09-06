package com.sheepfly.chapter2.part5.section3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceImpl implements Service{
    private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public void createCompany() {
        log.info("用户：张三");
        log.info("张三开始创业");
        log.info("张三正在创业");
        log.info("张三创业完成");
        log.info("张三公司成立");
    }

    @Override
    public void makeMoney() {
        log.info("开始赚钱");
        log.info("赚钱完成");
    }
}
