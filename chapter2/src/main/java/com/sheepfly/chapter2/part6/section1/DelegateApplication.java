package com.sheepfly.chapter2.part6.section1;

public class DelegateApplication {
    public static void main(String[] args) {
        // Software software = new Software();
        // OperateSystem operateSystem = new OperateSystem();
        // software.dispatchWork("graph", operateSystem);
        // software.dispatchWork("work", operateSystem);
        new Software().dispatchWork("graph", new OperateSystem());
    }
}
