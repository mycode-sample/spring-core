package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDao {
    private static final Logger log = LoggerFactory.getLogger(OrderDao.class);

    public int insert(Order order) {
        log.info("开始插入订单:" + order);
        return 1;
    }
}
