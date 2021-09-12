package com.sheepfly.chapter2.part6.section1;

import java.util.HashMap;
import java.util.Map;

public class OperateSystem implements HardWare {
    private Map<String, HardWare> map = new HashMap<>();

    public OperateSystem() {
        map.put("work", new Cpu());
        map.put("graph", new GraphCard());
    }


    @Override
    public void doWork(String msg) {
        map.get(msg).doWork(msg);
    }
}
