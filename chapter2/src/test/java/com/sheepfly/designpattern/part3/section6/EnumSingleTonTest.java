package com.sheepfly.designpattern.part3.section6;

import com.sheepfly.chapter2.part3.section6.EnumSingleTon;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class EnumSingleTonTest {
    @Test
    public void test() {
        try {
            EnumSingleTon singleTon1 = null;
            EnumSingleTon singleTon2 = EnumSingleTon.getInstance();
            singleTon2.setData(new Date());
            FileOutputStream os = new FileOutputStream("date");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(singleTon2);
            oos.flush();
            oos.close();

            FileInputStream is = new FileInputStream("date");
            ObjectInputStream ois = new ObjectInputStream(is);
            singleTon1 = (EnumSingleTon) ois.readObject();
            ois.close();
            System.out.println(singleTon1.getData());
            System.out.println(singleTon2.getData());
            System.out.println(singleTon1.getData() == singleTon2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObjectStream() {
        Date date = new Date();
        try {
            FileOutputStream os = new FileOutputStream("dateObj");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(date);
            oos.flush();
            oos.close();

            FileInputStream is = new FileInputStream("dateObj");
            ObjectInputStream ois = new ObjectInputStream(is);
            Date date2 = (Date) ois.readObject();
            System.out.println(date);
            System.out.println(date2);
            System.out.println(date == date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}