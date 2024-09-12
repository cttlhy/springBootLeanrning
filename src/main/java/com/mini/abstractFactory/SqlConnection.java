package com.mini.abstractFactory;

public class SqlConnection implements IConnection{
    @Override
    public void getConnection() {
        System.out.println("sql connect...");
    }
}
