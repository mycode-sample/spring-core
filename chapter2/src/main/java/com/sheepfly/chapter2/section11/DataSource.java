package com.sheepfly.chapter2.section11;

import java.util.Observable;

public class DataSource extends Observable {
    private static DataSource dataSource = null;
    private String name = "数据源";

    private DataSource() {
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public String getName() {
        return name;
    }

    public void executeQuery(Operation operation) {
        System.out.println("execute:" + operation.getOperation() + "," + operation.getSql());
        setChanged();
        notifyObservers(operation);
    }
}
