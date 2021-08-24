package com.sheepfly.chapter2.part4;

import org.example.beans.entity.User;

public class UserPlus extends User implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
