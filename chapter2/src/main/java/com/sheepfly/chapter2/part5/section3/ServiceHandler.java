package com.sheepfly.chapter2.part5.section3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class ServiceHandler implements InvocationHandler {
    private static Logger log = LoggerFactory.getLogger(ServiceHandler.class);
    private Service service;

    public ServiceHandler() {
    }

    public ServiceHandler(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("时间:" + new Date().toString());
        log.info("方法:" + method.getName());
        Object result = method.invoke(service, args);
        log.info("调用完成:" + new Date().toString());
        return result;
    }
}
