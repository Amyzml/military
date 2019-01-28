package com.daicy.military.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatUtil {

    private static Logger log = Logger.getLogger(DateFormatUtil.class);

    public static String DEFAULT_FORMATE = "yyyy-MM-dd HH:mm:ss";


    public static String longToDateFormat(Long time, String dateFormat) {
        if (CommonUtil.isNullOrEmpty(dateFormat)) {
            dateFormat = DEFAULT_FORMATE;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        date.setTime(time);
        return sdf.format(date);
    }


    public static Long dateFormatToLong(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMATE);
        Long result = null;
        try {
            result = sdf.parse(date).getTime();
        } catch (ParseException e) {
            log.error("parse to date error !", e);
        }
        return result;
    }
}
