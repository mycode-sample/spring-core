package com.sheepfly.designpattern.part3.section3;

import com.sheepfly.designpattern.part3.Singleton;

public class BetterLazySingleton implements Singleton {
    private volatile static BetterLazySingleton ton;

    public static BetterLazySingleton getInstance() {
        if (ton == null) {
            synchronized(BetterLazySingleton.class) {
                if (ton == null) {
                    ton = new BetterLazySingleton();
                }
            }
        }
        return ton;
    }
}
