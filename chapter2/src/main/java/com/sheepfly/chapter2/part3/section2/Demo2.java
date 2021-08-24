package com.sheepfly.chapter2.part3.section2;

import com.sheepfly.chapter2.part3.Singleton;

public class Demo2 implements Singleton {
    private static final Demo2 demo2;

    static {
        demo2 = new Demo2();
    }

    public static Demo2 getInstance() {
        return demo2;
    }
}
