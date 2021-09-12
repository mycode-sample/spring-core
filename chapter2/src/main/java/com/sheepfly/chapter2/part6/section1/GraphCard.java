package com.sheepfly.chapter2.part6.section1;

public class GraphCard implements HardWare {
    @Override
    public void doWork(String msg) {
        System.out.println("开始渲染画面:" + msg);
    }
}
