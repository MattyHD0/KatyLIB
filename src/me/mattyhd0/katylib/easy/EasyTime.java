package me.mattyhd0.katylib.easy;

public class EasyTime {

    public static final long MILLISECONDS_IN_SECOND = 1000;
    public static final long SECONDS_IN_MINUTE = 60;
    public static final long MINUTES_IN_HOUR = 60;
    public static final long HOURS_IN_DAY = 24;
    public static final long DAYS_IN_WEEK = 7;
    public static final long DAYS_IN_MONTH = 30;
    public static final long DAYS_IN_YEAR = 365;

    public static final long WEEKS_IN_MONTH = 4;
    public static final long MONTHS_IN_YEAR = 12;

    public static final long MS_IN_MILLISECOND = 1;
    public static final long MS_IN_SECOND = MS_IN_MILLISECOND * MILLISECONDS_IN_SECOND;
    public static final long MS_IN_MINUTE = MS_IN_SECOND * SECONDS_IN_MINUTE;
    public static final long MS_IN_HOUR = MS_IN_MINUTE * MINUTES_IN_HOUR;
    public static final long MS_IN_DAY = MS_IN_HOUR * HOURS_IN_DAY;

    public static final long MS_IN_YEAR = MS_IN_DAY * DAYS_IN_YEAR;
    public static final long MS_IN_MONTH = MS_IN_YEAR / MONTHS_IN_YEAR;
    public static final long MS_IN_WEEK = MS_IN_MONTH / WEEKS_IN_MONTH;

}
