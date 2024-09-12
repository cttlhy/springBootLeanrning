package com.mini.abstractFactory;

public class SqlConnectionFactory extends IDBFactory {

    @Override
    public IConnection createConnection() {
        return new SqlConnection();
    }

    @Override
    IDBReader createDBReader() {
        return new SqlReader();
    }
}
