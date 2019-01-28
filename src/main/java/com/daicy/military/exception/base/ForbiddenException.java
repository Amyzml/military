package com.daicy.military.exception.base;

public class ForbiddenException extends Exception {
    private static String message = "daicy.forbidden";

    public ForbiddenException() {
        super(message);
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
