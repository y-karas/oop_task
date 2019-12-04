package com.epam.task1.exceptions;

public class MyArrayFilterException extends Exception {

    public MyArrayFilterException (String s){
        super(s);
    }

    public MyArrayFilterException (String s, Exception innerEx){

    }
}
