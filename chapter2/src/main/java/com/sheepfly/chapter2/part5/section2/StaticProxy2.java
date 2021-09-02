package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

public class StaticProxy2 {
    private static final Logger log = LoggerFactory.getLogger(StaticProxy2.class);

    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            order.setCreateTime(format.parse("20210101").getTime());
            OrderService orderService = new OrderServiceStaticProxyImpl(new OrderServiceImpl());
            orderService.createOrder(order);
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
