package com.sheepfly.chapter2.part5.section2;

public class DynamicDataSourceEntry {
    public static final String DEFAULT_DATA_SOURCE = null;

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    private DynamicDataSourceEntry() {
    }

    public static void clear() {
        LOCAL.remove();
    }

    public static String get() {
        return LOCAL.get();
    }

    public static void restore() {
        LOCAL.set(DEFAULT_DATA_SOURCE);
    }

    public static void set(String dataSource) {
        LOCAL.set(dataSource);
    }

    public static void set(int year) {
        LOCAL.set("db_" + year);
    }
}
