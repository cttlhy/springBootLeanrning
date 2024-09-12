package com.mini.abstractFactory;

public class SqlReader implements IDBReader
{
    @Override
    public void read() {
        System.out.println("sql read...");
    }

    @Override
    public void setConnection() {
        System.out.printf("set sql connection");
    }
}
