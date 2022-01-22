package com.sheepfly.chapter2.section10;

public class BatterCakeWithEgg extends Battercake {
    @Override
    protected String getMessage() {
        return super.getMessage() + "鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 5;
    }
}
