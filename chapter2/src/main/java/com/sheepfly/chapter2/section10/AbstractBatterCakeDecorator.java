package com.sheepfly.chapter2.section10;

public abstract class AbstractBatterCakeDecorator extends Battercake{
    private Battercake battercake;

    public AbstractBatterCakeDecorator() {
    }

    public abstract void doWork();

    public AbstractBatterCakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMessage() {
        return this.battercake.getMessage();
    }

    @Override
    public int getPrice() {
        return this.battercake.getPrice();
    }
}
