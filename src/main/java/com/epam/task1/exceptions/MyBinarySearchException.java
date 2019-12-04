package com.epam.task1.exceptions;

public class MyBinarySearchException extends Exception{

    public MyBinarySearchException (String s){
        super(s);
    }

    public MyBinarySearchException (String s, Exception innerEx){
        super(s, innerEx);
    }
}
