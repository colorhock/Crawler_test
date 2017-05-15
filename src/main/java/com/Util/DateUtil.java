package com.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {
    /**
     * 时间格式:yyyy-MM-dd HH:mm:ss.
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式:yyyy-MM-dd.
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 时间格式:yyyy/MM/dd HH:mm:ss.
     */
    public static final String YYYY_MM_DD_HH_MM_SS_EN = "yyyy/MM/dd HH:mm:ss";
    /**
     * 
     * 时间格式:yyyy/MM/dd.
     */
    public static final String YYYY_MM_DD_EN = "yyyy/MM/dd";
    /**
     * 时间格式:yyyy年MM月dd日 HH:mm:ss.
     */
    public static final String YYYY_MM_DD_HH_MM_SS_CN = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * 时间格式:yyyy年MM月dd日.
     */
    public static final String YYYY_MM_DD_CN = "yyyy年MM月dd日";

    /**
     * 获取SimpleDateFormat
     * 
     * @param parttern
     *            日期格式
     * @return SimpleDateFormat对象
     * @throws RuntimeException
     *             异常：非法日期格式
     */
    private static SimpleDateFormat getDateFormat(String parttern)
            throws RuntimeException {
        return new SimpleDateFormat(parttern);
    }

    /**
     * 时间间隔.
     * 
     * @param startDate
     *            开始时间.
     * @return 时间间隔.
     */
    public static Long diffDate(Date startDate) {
        Long days = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateForDiff = new Date();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(sdf.parse(sdf.format(dateForDiff)));
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(sdf.parse(sdf.format(startDate)));
            long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 时间间隔.
     * 
     * @param startDate
     *            开始时间.
     * @return 时间间隔.
     */
    public static Long diffDatePlus(Date startDate) {
        Long days = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateForDiff = new Date();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(sdf.parse(sdf.format(dateForDiff)));
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(sdf.parse(sdf.format(startDate)));
            long diff = cal1.getTimeInMillis()-cal2.getTimeInMillis();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
    /**
     * 从指定日期开始到第几个月的日期.
     * 
     * @param month
     *            到第几个月的日期.
     * @return 从当前日期开始到第几个月的日期.;
     */
    public static Date startDateToMonth(final Date startDate,
            final int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     * 
     * @param date
     *            日期字符串
     * @param parttern
     *            日期格式
     * @return 日期
     */
    public static Date StringToDate(String date, String parttern) {
        Date myDate = null;
        if (date != null) {
            try {
                myDate = getDateFormat(parttern).parse(date);
            } catch (Exception e) {
            }
        }
        return myDate;
    }

    /**
     * 将日期转化为日期字符串。失败返回null。
     * 
     * @param date
     *            日期
     * @param parttern
     *            日期格式
     * @return 日期字符串
     */
    public static String DateToString(Date date, String parttern) {
        String dateString = null;
        if (date != null) {
            try {
                dateString = getDateFormat(parttern).format(date);
            } catch (Exception e) {
            }
        }
        return dateString;
    }

    public static void main(String[] args) {
        String strs[] = { "a", "bc", "cd" };
        System.err.println(StringUtils.join(strs, "_"));
    }
}
