package com.sheepfly.chapter2.section11;

import java.lang.reflect.Method;

public interface Listener {
    void addListener(String eventType, Object target);

    void addListener(String eventType, Object target, Method callback);

    void trigger(Event event);

    void trigger(String trigger);
}
