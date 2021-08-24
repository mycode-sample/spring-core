package com.sheepfly.designpattern.part3.section2;

import com.sheepfly.chapter2.part3.section2.EagerThread;
import org.junit.Test;

public class EagerThreadTest {
    @Test
    public void test() {
        Thread t1 = new Thread(new EagerThread());
        Thread t2 = new Thread(new EagerThread());
        t1.start();
        t2.start();
    }
}