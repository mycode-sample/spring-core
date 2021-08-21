package com.sheepfly.designpattern.part3.section3;

public class LazyThread implements Runnable{
    @Override
    public void run() {
        LazySingleTon ton = LazySingleTon.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + ton);
    }
}
