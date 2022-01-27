package com.sheepfly.chapter2.section11;

public class MouseEventDemo {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();
        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, callback);
        mouse.addListener(MouseEventType.ON_DOUBLE_CLICK, callback);
        mouse.addListener(MouseEventType.ON_UP, callback);
        mouse.addListener(MouseEventType.ON_DOWN, callback);

        mouse.click();
        mouse.doubleClick();
        mouse.up();
        mouse.down();
    }
}
