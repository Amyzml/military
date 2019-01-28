package com.daicy.military.util;

import javax.servlet.http.HttpServletRequest;

public class OperationLogUtil {

    public static void write(HttpServletRequest request, String operation, String object, String desc) {
        request.setAttribute("operation", operation);
        request.setAttribute("object", object);
        request.setAttribute("desc", desc);
    }
}
