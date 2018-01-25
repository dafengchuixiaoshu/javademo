package com.qiuan.framework.core.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiuan on 2017/11/8.
 */
public class Time {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");

    private static SimpleDateFormat weekFormat = new SimpleDateFormat("u"); //Day number of week (1 = Monday, ..., 7 = Sunday)

    /**
     * 获取当前时间星期
     * @return
     */
    public static Integer getWeek() {
        return getWeek(new Date());
    }

    /**
     * 获取指定毫秒数星期
     * @param ms
     * @return
     */
    public static Integer getWeek(long ms) {
        return getWeek(new Date(ms));
    }

    /**
     * 获取指定日期星期
     * @param date
     * @return
     */
    public static Integer getWeek(Date date) {
        try {
            return Integer.parseInt(weekFormat.format(date));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前毫米数
     * @return
     */
    public static Long getTimeStamp() {
        return getTimeStamp(new Date());
    }

    /**
     * 获取指定date毫秒数
     * @param date
     * @return
     */
    public static Long getTimeStamp(Date date) {
        try {
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String getDate() {
        return getDate(new Date());
    }

    /**
     * 获取指定时间戳日期
     * @param ms
     * @return
     */
    public static String getDate(long ms) {
        return getDate(new Date(ms));
    }

    /**
     * 获取指定date对应的日期
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getTime() {
        return getTime(new Date());
    }

    /**
     * 获取指定毫秒数时间
     * @param ms
     * @return
     */
    public static String getTime(long ms) {
        return getTime(new Date(ms));
    }

    /**
     * 获取指定日期时间
     * @param date
     * @return
     */
    public static String getTime(Date date) {
        try {
            return timeFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前日期和时间，精确到毫秒
     * @param separator
     * @return
     */
    public static String getDateAndTime(String separator) {
        return getDateAndTime(new Date(), separator);
    }

    /**
     * 获取指定毫秒数日期和时间，精确到毫秒
     * @param ms
     * @param separator
     * @return
     */
    public static String getDateAndTime(long ms, String separator) {
        return getDateAndTime(new Date(ms), separator);
    }

    /**
     * 获取指定日期和时间，精确到毫秒
     * @param date
     * @param separator
     * @return
     */
    public static String getDateAndTime(Date date, String separator) {
        
        String dateStr = getDate(date);

        String timeStr = getTime(date);

        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(timeStr)) {
            return null;
        }

        return dateStr + separator + timeStr;
    }


    public enum FormatType {
        WEEK,
        DATE,
        TIME,
        DATA_TIME;
    }

    private static long DAY_MS = 24 * 3600 * 1000;

    /**
     * 获取当前日期偏移天数后的日期、时间、星期
     * @param offset 偏移天数
     * @param formatType 获取类型
     * @return
     */
    public static String get(long offset, FormatType formatType) {
        return get(new Date(), offset, formatType, " ");
    }

    public static String get(long offset, FormatType formatType, String separator) {
        return get(new Date(), offset, formatType, separator);
    }

    /**
     * 获取指定毫秒数偏移天数后的日期、时间、星期
     * @param offset 偏移天数
     * @param formatType 获取类型
     * @return
     */
    public static String get(long ms, long offset, FormatType formatType) {
        return get(new Date(ms), offset, formatType, " ");
    }

    public static String get(long ms, long offset, FormatType formatType, String separator) {
        return get(new Date(ms), offset, formatType, separator);
    }

    /**
     * 获取指定日期偏移天数后的日期、时间、星期
     * @param offset 偏移天数
     * @param formatType 获取类型
     * @return
     */
    public static String get(Date date, long offset, FormatType formatType, String separator) {

        Date dstDate = new Date(date.getTime() + offset * DAY_MS);

        switch (formatType) {

            case DATE: {
                return getDate(dstDate);
            }
            case TIME: {
                return getTime(dstDate);
            }
            case WEEK: {
                return String.valueOf(getWeek(dstDate));
            }
            case DATA_TIME: {
                return getDateAndTime(dstDate, separator);
            }
            default: {
                return null;
            }
        }
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {

        Date date = new Date();

        System.out.println("ms:" + Time.getTimeStamp(date));
        System.out.println("date:" + Time.getDate(date));
        System.out.println("time:" + Time.getTime(date));
        System.out.println("both:" + Time.getDateAndTime(date, " "));
        System.out.println("week:" + Time.getWeek(date));
        System.out.println("any:" + Time.get(date, 1, FormatType.DATA_TIME, "_"));
        System.out.println("any:" + Time.get(date, -1, FormatType.DATA_TIME, "_"));
    }
}
