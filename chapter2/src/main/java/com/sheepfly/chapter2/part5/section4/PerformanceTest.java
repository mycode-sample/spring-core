package com.sheepfly.chapter2.part5.section4;

import cn.hutool.core.date.StopWatch;
import com.sheepfly.chapter2.part5.section3.Service;
import com.sheepfly.chapter2.part5.section3.ServiceImpl;
import com.sheepfly.chapter2.part5.section3.ServiceProxy;

public class PerformanceTest {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("task", true);
        stopWatch.start("无代理");
        Service service = new ServiceImpl();
        for (int i = 0; i < 10000; i++) {
            if (i % 1000 == 0) {
                System.out.println("无代理:" + i);
            }
            service.makeMoney();
            service.createCompany();
        }
        Service serviceProxy = ServiceProxy.getServiceProxy(service);
        stopWatch.stop();
        stopWatch.start("有代理");
        for (int i = 0; i < 10000; i++) {
            if (i % 1000 == 0) {
                System.out.println("有代理:" + i);
            }
            serviceProxy.makeMoney();
            serviceProxy.createCompany();
        }
        stopWatch.stop();
        System.out.println(stopWatch.toString());
    }
}
