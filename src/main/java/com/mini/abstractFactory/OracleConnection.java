package com.mini.abstractFactory;

public class OracleConnection implements IConnection{
    @Override
    public void getConnection() {
        System.out.println("oracle connect...");
    }
}
