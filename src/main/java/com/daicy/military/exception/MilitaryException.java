package com.daicy.military.exception;


import com.daicy.military.exception.base.InternalException;

public class MilitaryException extends InternalException {
    private static String message = "daicy.military.connection.exception";

    public MilitaryException() {
        super(message);
    }
}