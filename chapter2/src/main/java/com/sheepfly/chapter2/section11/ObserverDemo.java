package com.sheepfly.chapter2.section11;

public class ObserverDemo {
    public static void main(String[] args) {
        DataSource dataSource = DataSource.getInstance();
        Operation select = new Operation("select", "select all");
        Operation delete = new Operation("delete", "delete one");

        Jdbc jdbc = new Jdbc();
        DataBase dataBase = new DataBase();

        dataSource.addObserver(jdbc);
        dataSource.addObserver(dataBase);
        
        dataSource.executeQuery(select);
        dataSource.executeQuery(delete);
    }
}
