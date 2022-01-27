package com.sheepfly.chapter2.section11;

public class Mouse extends EventListener{
    public void click() {
        System.out.println("单击");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick() {
        System.out.println("双击");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up() {
        System.out.println("释放");
        this.trigger(MouseEventType.ON_UP);
    }

    public void down() {
        System.out.println("长按");
        this.trigger(MouseEventType.ON_DOWN);
    }
}
