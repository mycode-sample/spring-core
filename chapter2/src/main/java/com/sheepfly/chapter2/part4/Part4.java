package com.sheepfly.chapter2.part4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Part4 {
    private static final Logger log = LoggerFactory.getLogger(Part4.class);

    public static void main(String[] args) {
        UserPlus userPlus = new UserPlus();
        userPlus.setName("张三");
        userPlus.setAge(12);
        try {
            Object clone = userPlus.clone();
            log.info(clone.getClass().getName());
        } catch (CloneNotSupportedException e) {
            log.error("错误", e);
        }
    }
}
