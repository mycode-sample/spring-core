package com.sheepfly.chapter2.part5.section2;

public class StatisticProxy {
    public static void main(String[] args) {
        SuperService service = new Service();
        SuperService serviceProxy = new ServiceProxy(service);
        serviceProxy.createCompany();
    }
}
