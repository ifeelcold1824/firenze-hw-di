package com.tp.di.exception;

public class BaseException extends RuntimeException{
    public BaseException(String message){
        super(message);
    }

    public BaseException(Exception ex){
        super(ex);
    }
}
