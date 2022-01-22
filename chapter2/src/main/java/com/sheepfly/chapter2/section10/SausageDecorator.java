package com.sheepfly.chapter2.section10;

public class SausageDecorator extends AbstractBatterCakeDecorator{
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public void doWork() {
    }

    @Override
    protected String getMessage() {
        return super.getMessage() + "香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 10;
    }
}
