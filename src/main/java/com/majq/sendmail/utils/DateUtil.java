package com.majq.sendmail.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static long getTimeMillis(String time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDateTime = null;
        try {
            currentDateTime = df.parse(df1.format(new Date()) + time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDateTime.getTime();
    }
}
