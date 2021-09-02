package com.sheepfly.chapter2.part5.section2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order {
    private static final Logger log = LoggerFactory.getLogger(Order.class);

    private Object orderInfo;
    private Long createTime;
    private String id;

    public static Logger getLog() {
        return log;
    }

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
