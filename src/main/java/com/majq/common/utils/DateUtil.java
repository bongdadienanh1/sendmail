package com.majq.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static long getTimeMillis(String time) {
        if (StringUtils.isBlank(time)) System.out.println("getTimeMillis time can not be null!");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDateTime = null;
        try {
            currentDateTime = df.parse(df1.format(new Date()) + " " + time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDateTime.getTime();
    }
}
