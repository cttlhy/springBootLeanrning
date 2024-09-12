package com.mini.abstractFactory;

public class OracleConnectionFactory extends IDBFactory{

    @Override
    IConnection createConnection() {
        return null;
    }

    @Override
    IDBReader createDBReader() {
        return null;
    }
}
