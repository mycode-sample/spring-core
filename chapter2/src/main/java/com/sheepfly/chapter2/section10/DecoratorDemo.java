package com.sheepfly.chapter2.section10;

public class DecoratorDemo {
    public static void main(String[] args) {
        Battercake b1 = new Battercake();
        System.out.println(b1.getMessage() + ":" + b1.getPrice());
        BatterCakeWithEgg b2 = new BatterCakeWithEgg();
        System.out.println(b2.getMessage() + ":" + b2.getPrice());
        BatterCakeWithEggAndSausage b3 = new BatterCakeWithEggAndSausage();
        System.out.println(b3.getMessage() + ":" + b3.getPrice());

        Battercake battercake = new Battercake();
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMessage() + ":" + battercake.getPrice());
    }
}
