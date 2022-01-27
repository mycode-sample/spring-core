package com.sheepfly.chapter2.section11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件监听器。
 */
public class EventListener {
    /**
     * 已经注册的事件。
     */
    protected Map<String, Event> eventMap = new HashMap<>();

    /**
     * 注册事件。
     *
     * @param eventType 事件类型
     * @param target 要通知的目标
     */
    public void addListener(String eventType, Object target) {
        try {
            this.addListener(eventType, target, target.getClass().getMethod(eventType, Event.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册事件。
     *
     * @param eventType 事件类型。
     * @param target 要通知的对象。
     * @param callback 触发事件后要执行从操作。
     */
    public void addListener(String eventType, Object target, Method callback) {
        eventMap.put(eventType, new Event(target, callback));
    }

    /**
     * 触发事件。
     *
     * @param event 要触发的事件。
     */
    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        if (event.getCallback() != null) {
            try {
                event.getCallback().invoke(event.getTarget(), event);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 触发事件。
     *
     * @param trigger 要触发的事件名称。
     */
    protected void trigger(String trigger) {
        if (this.eventMap.containsKey(trigger)) {
            Event event = this.eventMap.get(trigger);
            event.setTrigger(trigger);
            trigger(event);
        }
    }

    private String toUpperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
