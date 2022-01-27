package com.sheepfly.chapter2.section11;

public class Operation {
    private String operation;
    private String sql;

    private Operation() {
    }

    public Operation(String operation, String sql) {
        this.operation = operation;
        this.sql = sql;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
