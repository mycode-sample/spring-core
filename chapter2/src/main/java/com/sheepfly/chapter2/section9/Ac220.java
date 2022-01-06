package com.sheepfly.chapter2.section9;

public class Ac220 {
    private int output = 220;

    public int output() {
        System.out.println("开始充电");
        System.out.println("输出电压:" + output);
        System.out.println("充电完成");
        return output;
    }
}
