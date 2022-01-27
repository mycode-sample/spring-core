package com.sheepfly.chapter2.section11;

import java.util.Observable;
import java.util.Observer;

public class Jdbc implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        DataSource dataSource = (DataSource) o;
        Operation operation = (Operation) arg;
        System.out.println("jdbc:" + operation
                .getOperation() + "," + operation.getSql());

    }
}
