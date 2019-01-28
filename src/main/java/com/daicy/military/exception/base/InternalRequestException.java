package com.daicy.military.exception.base;

public class InternalRequestException extends InternalException {
    private static String message = "daicy.internal.request.exception";

    public InternalRequestException() {
        super(message);
    }
}
