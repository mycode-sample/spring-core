package com.sheepfly.chapter2.part5.section3.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class CglibProxyApp {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                CglibProxyApp.class.getResource("/").getPath());
        CglibProxy cglibProxy = new CglibProxy();
        CglibService service = cglibProxy.getEnhancer(CglibService.class);
        service.createCompany();
        service.makeMoney();
    }
}
