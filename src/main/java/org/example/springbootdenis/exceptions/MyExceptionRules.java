package org.example.springbootdenis.exceptions;

public class MyExceptionRules extends RuntimeException {
    public MyExceptionRules(String exceptionMessage) {
        super(exceptionMessage);
    }
}
