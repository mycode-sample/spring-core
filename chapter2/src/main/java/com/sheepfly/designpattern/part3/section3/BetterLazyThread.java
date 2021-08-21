package com.sheepfly.designpattern.part3.section3;

public class BetterLazyThread implements Runnable {
    @Override
    public void run() {
        LazyInnerSingleton ton = LazyInnerSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + ton);
    }
}
