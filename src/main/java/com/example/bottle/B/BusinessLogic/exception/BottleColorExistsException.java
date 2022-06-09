package com.example.bottle.B.BusinessLogic.exception;

public class BottleColorExistsException extends RuntimeException {


    public BottleColorExistsException(String color){
        super("the color '" + color + "' already exists in this database");
    }

}
