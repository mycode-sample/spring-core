package com.sheepfly.designpattern.part3.section3;

import com.sheepfly.designpattern.part3.Singleton;

import java.io.Serializable;

public class LazySingleTon implements Singleton, Serializable {
    private static LazySingleTon ton = null;
    public synchronized static LazySingleTon getInstance() {
        if (ton == null) {
            ton = new LazySingleTon();
        }
        return ton;
    }
    /**
     * 解决反序列化破环单例对象的问题。
     */
    private Object readResolve() {
        return ton;
    }
}
