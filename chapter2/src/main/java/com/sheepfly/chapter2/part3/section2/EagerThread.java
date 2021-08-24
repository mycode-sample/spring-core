package com.sheepfly.chapter2.part3.section2;

public class EagerThread implements Runnable{
    @Override
    public void run() {
        Demo2 demo = Demo2.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + demo);
    }
}
