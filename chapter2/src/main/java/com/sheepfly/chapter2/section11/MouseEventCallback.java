package com.sheepfly.chapter2.section11;

public class MouseEventCallback {
    public void onClick(Event event) {
        System.out.println("触发事件:" + event);
    }

    public void onDoubleClick(Event event) {
        System.out.println("触发事件:" + event);
    }

    public void onUp(Event event) {
        System.out.println("触发事件:" + event);
    }

    public void onDown(Event event) {
        System.out.println("触发事件:" + event);
    }
}
