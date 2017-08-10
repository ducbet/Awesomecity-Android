package com.framgia.awesomecity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lamvu on 8/10/2017.
 */

public class Utils {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public static String getWaitingTime(String startTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        Calendar now = Calendar.getInstance();

        Date time, currentTime;
        long wait = 0;

        try {
            Date date = sdf.parse(startTime);
            String time1 = output.format(date);
            time = output.parse(time1);

            String time2 = output.format(now.getTime());
            currentTime = output.parse(time2);

            wait = currentTime.getTime() - time.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(wait < MINUTE_MILLIS)
            return "just now";
        else if(wait < 2 * MINUTE_MILLIS)
            return "a minute ago";
        else if(wait < 50 * MINUTE_MILLIS)
            return wait / MINUTE_MILLIS + " minutes ago";
        else if(wait < 90 * MINUTE_MILLIS)
            return "an hour ago";
        else if(wait < 24 * HOUR_MILLIS)
            return wait / HOUR_MILLIS + " hours ago";
        else if(wait < 48 * HOUR_MILLIS)
            return "yesterday";
        return wait / DAY_MILLIS + " days ago";
    }

    /*public static String getWaitingTime(String startTime, Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        Calendar now = Calendar.getInstance();

        Date time, currentTime;
        long wait = 0;

        try {
            Date date = sdf.parse(startTime);
            String time1 = output.format(date);
            time = output.parse(time1);

            String time2 = output.format(now.getTime());
            currentTime = output.parse(time2);

            wait = currentTime.getTime() - time.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(wait < MINUTE_MILLIS)
            return context.getString(R.string.time_wait_now);
        else if(wait < 2 * MINUTE_MILLIS)
            return context.getString(R.string.time_wait_minute);
        else if(wait < 50 * MINUTE_MILLIS)
            return wait / MINUTE_MILLIS + context.getString(R.string.time_wait_minutes);
        else if(wait < 90 * MINUTE_MILLIS)
            return context.getString(R.string.time_wait_hour);
        else if(wait < 24 * HOUR_MILLIS)
            return wait / HOUR_MILLIS + context.getString(R.string.time_wait_hours);
        else if(wait < 48 * HOUR_MILLIS)
            return context.getString(R.string.time_wait_yesterday);
        return wait / DAY_MILLIS + context.getString(R.string.time_wait_days);
    }*/

}
