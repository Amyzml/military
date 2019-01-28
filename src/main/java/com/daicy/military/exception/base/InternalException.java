package com.daicy.military.exception.base;

public class InternalException extends Exception {
    private static String message = "daicy.internal.server.error";

    public InternalException() {
        super(message);
    }

    public InternalException(String message) {
        super(message);
    }
}
