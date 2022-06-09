package com.example.bottle.B.BusinessLogic.exception;

public class RecordNotFound extends RuntimeException{

    public RecordNotFound(String message){
        super("error: " + message);
    }
}
