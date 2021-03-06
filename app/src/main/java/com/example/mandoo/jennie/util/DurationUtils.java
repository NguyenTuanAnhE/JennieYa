package com.example.mandoo.jennie.util;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DurationUtils {

    public static String getDuration(long time) {
        long min, sec, hour;
        time = time / 1000;
        hour = TimeUnit.SECONDS.toHours(time);
        if (hour == 0) {
            min = TimeUnit.SECONDS.toMinutes(time);
            sec = time - min * 60;
        } else {
            min = TimeUnit.SECONDS.toMinutes(time - hour * 60 * 60);
            sec = time - hour * 60 * 60 - min * 60;
        }

        String duration;
        if (hour == 0) {
            duration = String.format(Locale.ENGLISH, "%02d:%02d", min, sec);
        } else {
            duration = String.format(Locale.ENGLISH, "%02d:%02d:%02d", hour, min, sec);
        }

        return duration;
    }
}
