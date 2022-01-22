package com.sheepfly.chapter2.section10;

public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg{
    @Override
    protected String getMessage() {
        return super.getMessage() + "香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 12;
    }
}
