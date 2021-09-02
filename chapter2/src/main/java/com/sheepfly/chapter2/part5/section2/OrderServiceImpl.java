package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderDao orderDao = new OrderDao();

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
