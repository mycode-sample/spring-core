package com.sheepfly.chapter2.part5.section3.jdkproxy;

import com.sheepfly.chapter2.part5.section3.ServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class JdkProxy {
    public static void main(String[] args) {
        byte[] bytes = ProxyGenerator.generateProxyClass("$proxy.class", ServiceImpl.class.getInterfaces());
        OutputStream os = null;
        try {
            os = new FileOutputStream("$proxy.class");
            os.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
