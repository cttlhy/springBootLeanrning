package com.mini.abstractFactory;

public class SqlDBReaderFactory extends IDBFactory{

    @Override
    IConnection createConnection() {
        return new SqlConnection();
    }

    @Override
    IDBReader createDBReader() {
        return null;
    }
}
