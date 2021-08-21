package com.sheepfly.designpattern.part3.section3;

import com.sheepfly.designpattern.part3.Singleton;

public class LazyInnerSingleton2 implements Singleton {
    private LazyInnerSingleton2() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("禁止创建多个实例");
        }
    }

    public static final LazyInnerSingleton2 getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyInnerSingleton2 LAZY = new LazyInnerSingleton2();
    }
}
