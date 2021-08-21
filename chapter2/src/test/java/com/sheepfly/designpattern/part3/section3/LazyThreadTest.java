package com.sheepfly.designpattern.part3.section3;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class LazyThreadTest {

    /**
     * 懒汉式单例模式。
     *
     * 加锁和不加锁。
     */
    @Test
    public void test1() {
        Thread t1 = new Thread(new LazyThread());
        Thread t2 = new Thread(new LazyThread());
        Thread t3 = new Thread(new LazyThread());
        Thread t4 = new Thread(new LazyThread());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /**
     * 使用内部类实现锁机制的懒汉式单例模式。
     */
    @Test
    public void test2() {
        Thread t1 = new Thread(new BetterLazyThread());
        Thread t2 = new Thread(new BetterLazyThread());
        Thread t3 = new Thread(new BetterLazyThread());
        Thread t4 = new Thread(new BetterLazyThread());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /**
     * 反射破坏单例对象。
     */
    @Test
    public void test3() {
        try {
            Class<?> clazz = LazyInnerSingleton.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object obj1 = c.newInstance();
            Object obj2 = c.newInstance();
            System.out.println(obj1 == obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解决反射破坏单例对象。
     */
    @Test
    public void test4() {
        try {
            Class<?> clazz = LazyInnerSingleton2.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object obj1 = c.newInstance();
            Object obj2 = c.newInstance();
            System.out.println(obj1 == obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 序列化破坏单例对象。
     */
    @Test
    public void test5() {
        LazySingleTon ton = null;
        LazySingleTon ton2 = LazySingleTon.getInstance();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("singleTon.obj");
            ObjectOutputStream out2 = new ObjectOutputStream(out);
            out2.writeObject(ton2);
            out2.flush();
            out2.close();

            FileInputStream in = new FileInputStream("singleTon.obj");
            ObjectInputStream in2 = new ObjectInputStream(in);
            ton = (LazySingleTon) in2.readObject();
            in.close();

            System.out.println(ton == ton2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}