package com.sheepfly.chapter2.section10;

public class EggDecorator extends AbstractBatterCakeDecorator {

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMessage() {
        return super.getMessage() + "鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 5;
    }

    @Override
    public void doWork() {
    }
}
