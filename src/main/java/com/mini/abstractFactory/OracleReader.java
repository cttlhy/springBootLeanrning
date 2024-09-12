package com.mini.abstractFactory;

public class OracleReader implements IDBReader{
    @Override
    public void read() {
        System.out.println("oracle read...");
    }

    @Override
    public void setConnection() {
        System.out.printf("set ");
    }
}
