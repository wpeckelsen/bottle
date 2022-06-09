package com.example.bottle.B.BusinessLogic.exception;

public class FactoryCodeExistsException extends RuntimeException{

    public FactoryCodeExistsException(String factoryCode){
        super("that bottle already exists in this database. factory code: " + factoryCode);
    }
}
