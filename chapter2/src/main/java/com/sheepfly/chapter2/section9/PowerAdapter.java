package com.sheepfly.chapter2.section9;

public class PowerAdapter implements Dc5{
    private Ac220 ac220;

    private PowerAdapter() {
    }

    public PowerAdapter(Ac220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDc5() {
        int ac220 = this.ac220.output();
        int dc5 = ac220 / 44;
        System.out.println("输入电压:" + ac220);
        System.out.println("输出电压:" + dc5);
        return dc5;
    }
}
