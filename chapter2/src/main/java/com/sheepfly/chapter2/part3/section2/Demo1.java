package com.sheepfly.chapter2.part3.section2;

import com.sheepfly.chapter2.part3.Singleton;

public class Demo1 implements Singleton {
    private static final Demo1 demo1;

    static {
        demo1 = new Demo1();
    }

    public static Demo1 getInstance() {
        return demo1;
    }
}
