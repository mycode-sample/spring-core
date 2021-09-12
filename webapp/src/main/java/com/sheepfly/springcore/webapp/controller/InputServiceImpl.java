package com.sheepfly.springcore.webapp.controller;

public class InputServiceImpl implements Service{
    @Override
    public void doService(String msg) {
        System.out.println("进货:" + msg);
    }
}
