package com.mini.abstractFactory;

public class OracleDBReaderFactory extends IDBFactory{

    @Override
    IConnection createConnection() {
        return null;
    }

    @Override
    IDBReader createDBReader() {
        return null;
    }
}
