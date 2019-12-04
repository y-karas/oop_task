package com.epam.task1.exceptions;

public class MyFileUtilException extends Exception{

    public MyFileUtilException (String s){
        super(s);
    }

    public MyFileUtilException (String s, Exception innerEx){
        super(s, innerEx);
    }
}
