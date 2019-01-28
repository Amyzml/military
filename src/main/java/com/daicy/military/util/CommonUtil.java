package com.daicy.military.util;

import java.util.Collection;
import java.util.regex.Pattern;


public class CommonUtil {


    public static boolean isNullOrEmpty(String args) {
        if (args == null || "".equals(args)) {
            return true;
        }
        return args.isEmpty();
    }


    public static boolean isNullOrEmpty(Object args) {
        if (args == null) {
            return true;
        }
        return false;
    }


    public static boolean isNullOrEmpty(Collection<?> args) {
        if (args == null || args.size() == 0) {
            return true;
        }
        return args.isEmpty();
    }

    public static String ifNullGetEmpty(String args) {
        if (args == null) {
            return "";
        }
        return args;
    }


    /**
     * 防止sql注入校验
     */
    public static boolean isValid(String str) {
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
                + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        if (sqlPattern.matcher(str).find()) {
            return false;
        }
        return true;
    }


}
