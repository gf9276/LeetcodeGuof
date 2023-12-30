package com.guof.day_of_the_week;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String input = year + "-" + month + "-" + day;
        return getWeek(input);
    }

    public static String getWeek(String sdate) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int week_index = 0;
        try {
            // 再转换为时间
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = dateFormat.parse(sdate);
            Calendar c = Calendar.getInstance();
            c.setTime(parseDate);
            week_index = c.get(Calendar.DAY_OF_WEEK) - 1;
            if (week_index < 0) {
                week_index = 0;
            }
        } catch (Exception ignored) {

        }
        return weeks[week_index];
    }
}