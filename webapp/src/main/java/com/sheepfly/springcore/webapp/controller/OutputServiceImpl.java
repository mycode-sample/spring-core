package com.sheepfly.springcore.webapp.controller;

public class OutputServiceImpl implements Service{
    @Override
    public void doService(String msg) {
        System.out.println("出货:" + msg);
    }
}
