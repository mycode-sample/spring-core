package com.sheepfly.chapter2.part5.section2;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
    private static final Logger log = LoggerFactory.getLogger(Service.class);

    private User user;

    private Company company;

    public void createCompany() {
        log.info("开始创建公司，创始人:" + user.getName());
        log.info("正在创建公司");
        log.info("公司创建完成:" + company.getName());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
