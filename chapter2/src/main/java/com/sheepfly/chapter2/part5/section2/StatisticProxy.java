package com.sheepfly.chapter2.part5.section2;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;

public class StatisticProxy {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        Company company = new Company();
        company.setName("张三的公司");
        Service service = new Service();
        service.setCompany(company);
        service.setUser(user);
        Proxy proxy = new Proxy(new Service());
        proxy.createCompany();
    }
}
