package com.sheepfly.chapter2.section10;

public class DefaultBatterCake extends AbstractBatterCake{
    @Override
    protected String getMessage() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
