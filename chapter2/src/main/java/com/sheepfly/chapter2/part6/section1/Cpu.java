package com.sheepfly.chapter2.part6.section1;

public class Cpu implements HardWare {
    @Override
    public void doWork(String msg) {
        System.out.println("开始计算任务" + msg);
    }
}
