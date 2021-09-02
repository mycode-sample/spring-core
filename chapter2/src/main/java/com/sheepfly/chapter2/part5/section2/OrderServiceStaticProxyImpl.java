package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxyImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceStaticProxyImpl.class);

    private OrderService orderService;

    public OrderServiceStaticProxyImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(format.format(new Date()));
        log.info("分配到数据源:" + dbRouter);
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
