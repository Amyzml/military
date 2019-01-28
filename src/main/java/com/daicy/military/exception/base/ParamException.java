package com.daicy.military.exception.base;

public class ParamException extends Exception {
    private static String message = "daicy.param.error";

    public ParamException() {
        super(message);
    }

    public ParamException(String message) {
        super(message);
    }

}
