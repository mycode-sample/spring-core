package com.sheepfly.designpattern.part2.section2;

public class PersonComputer implements Computer {
    @Override
    public void playGame() {
        System.out.println("个人电脑");
    }
}
