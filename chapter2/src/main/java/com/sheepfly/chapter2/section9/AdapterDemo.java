package com.sheepfly.chapter2.section9;

public class AdapterDemo {
    public static void main(String[] args) {
        Dc5 dc5 = new PowerAdapter(new Ac220());
        System.out.println(dc5.outputDc5());
    }
}
