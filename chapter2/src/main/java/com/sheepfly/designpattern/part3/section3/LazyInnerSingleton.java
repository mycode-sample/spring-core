package com.sheepfly.designpattern.part3.section3;

import com.sheepfly.designpattern.part3.Singleton;

public class LazyInnerSingleton implements Singleton {
    private LazyInnerSingleton() {}
    public static final LazyInnerSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyInnerSingleton LAZY = new LazyInnerSingleton();
    }
}
