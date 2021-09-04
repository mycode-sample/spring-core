package com.sheepfly.chapter2.part5.section3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ServiceProxy {
    private static final Logger log = LoggerFactory.getLogger(ServiceProxy.class);

    public static Service getSimpleServiceProxy(Service service) {
        InvocationHandler handler = new ServiceHandler(service);
        log.info("获取代理对象");
        Service obj = (Service) Proxy
                .newProxyInstance(Service.class.getClassLoader(), ServiceImpl.class.getInterfaces(), handler);
        log.info("获取完成");
        return obj;
    }

    public static Service getServiceProxy(Service service) {
        InvocationHandler handler = new ServiceHandler(service);
        Class<?> proxy = Proxy.getProxyClass(Service.class.getClassLoader(), Service.class);
        try {
            log.info("获取代理对象");
            Service obj = (Service) proxy.getConstructor(InvocationHandler.class).newInstance(handler);
            log.info("代理对象获取完成");
            return obj;
        } catch (Exception e) {
            log.error("发生异常", e);
        }
        return null;
    }
}
