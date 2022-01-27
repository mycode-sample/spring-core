package com.sheepfly.chapter2.section11;

import java.lang.reflect.Method;

/**
 * 事件。
 */
public class Event {
    /**
     * 事件由谁发起。
     */
    private Object source;
    /**
     * 事件触发后，要通知的对象。
     */
    private Object target;
    /**
     * 事件触发后做什么动作。
     */
    private Method callback;
    /**
     * 触发的事件名称。
     */
    private String trigger;
    /**
     * 触发时间。
     */
    private long time;

    public Event() {
    }

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
