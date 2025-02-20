package cn.starry.skywars.proxy.util;

public class TimeUtil {
    public static String getTime(int seconds) {
        if (seconds < 60) {
            return seconds + "秒";
        } else {
            int minutes = seconds / 60;
            int s = 60 * minutes;
            int secondsLeft = seconds - s;
            if (minutes < 60) {
                return secondsLeft > 0 ? minutes + "分钟" + secondsLeft + "秒" : minutes + "分钟";
            } else {
                String time;
                int days;
                int inMins;
                int leftOver;
                if (minutes < 1440) {
                    days = minutes / 60;
                    time = days + "小时";
                    inMins = 60 * days;
                    leftOver = minutes - inMins;
                    if (leftOver >= 1) {
                        time = time + " " + leftOver + "分钟";
                    }

                    if (secondsLeft > 0) {
                        time = time + " " + secondsLeft + "秒";
                    }

                    return time;
                } else {
                    days = minutes / 1440;
                    time = days + "天";
                    inMins = 1440 * days;
                    leftOver = minutes - inMins;
                    if (leftOver >= 1) {
                        if (leftOver < 60) {
                            time = time + " " + leftOver + "分钟";
                        } else {
                            int hours = leftOver / 60;
                            time = time + " " + hours + "小时";
                            int hoursInMins = 60 * hours;
                            int minsLeft = leftOver - hoursInMins;
                            time = time + " " + minsLeft + "分钟";
                        }
                    }

                    if (secondsLeft > 0) {
                        time = time + " " + secondsLeft + "秒";
                    }

                    return time;
                }
            }
        }
    }
}
