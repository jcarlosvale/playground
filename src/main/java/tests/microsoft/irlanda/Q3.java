package tests.microsoft.irlanda;

import java.time.DayOfWeek;

public class Q3 {
    public static int solution(String S) {
        int WEEK_MINUTES = 7 * 24 * 60;
        boolean [] availabilityMinutes = new boolean[WEEK_MINUTES];
        //parse days
        for(String day : S.split("\n")) {
            int dayOfWeek = parseDayOfWeek(day.substring(0, 3).trim());
            int startHour =  Integer.parseInt(day.substring(4,6));
            int startMinute =  Integer.parseInt(day.substring(7,9));
            int endHour =  Integer.parseInt(day.substring(10,12));
            int endMinute =  Integer.parseInt(day.substring(13,15));

            int startMeeting = dayOfWeek + (startHour * 60) + startMinute;
            int endMeeting = dayOfWeek + (endHour * 60) + startMinute;
            availabilityMinutes[startMeeting] = true;
            availabilityMinutes[endMeeting] = true;
        }

        //identify max space
        int maxRest = 0;
        int counter = 0;
        boolean busy = false;
        for(boolean minutes: availabilityMinutes) {
            if (minutes) {
                if (!busy) {
                    maxRest = Math.max(maxRest, counter);
                    counter = 0;
                }
                busy = !busy;
            } else {
                if (!busy) counter++;
            }
        }
        if (!busy) {
            maxRest = Math.max(maxRest, counter);
        }

        return maxRest+1;
    }

    private static int parseDayOfWeek(String dayOfWeek) {
        switch (dayOfWeek) {
            case "Mon" : return 0;
            case "Tue" : return 1440;
            case "Wed" : return 2880;
            case "Thu" : return 4320;
            case "Fri" : return 5760;
            case "Sat" : return 7200;
            default: return 8640;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00")); //180
        System.out.println(solution("Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00")); //505
        System.out.println(solution("")); //505
    }
}
