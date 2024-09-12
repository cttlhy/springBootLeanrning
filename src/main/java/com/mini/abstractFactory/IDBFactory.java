package com.mini.abstractFactory;

abstract class IDBFactory {

    abstract IConnection createConnection();

    abstract IDBReader createDBReader();
}
