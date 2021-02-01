package tests.opera;

import java.time.DayOfWeek;
import java.util.*;

public class Q1 {

    static class Interval{
        DayOfWeek dayOfWeek;
        int start;
        int end;

        public Interval(DayOfWeek dayOfWeek, int start, int end) {
            this.dayOfWeek = dayOfWeek;
            this.start = start;
            this.end = end;
        }
    }

    public static int solution(String S) {
        Map<String, DayOfWeek> mapDayOfWeek = new HashMap<>();
        mapDayOfWeek.put("Mon", DayOfWeek.MONDAY);
        mapDayOfWeek.put("Tue", DayOfWeek.TUESDAY);
        mapDayOfWeek.put("Wed", DayOfWeek.WEDNESDAY);
        mapDayOfWeek.put("Thu", DayOfWeek.THURSDAY);
        mapDayOfWeek.put("Fri", DayOfWeek.FRIDAY);
        mapDayOfWeek.put("Sat", DayOfWeek.SATURDAY);
        mapDayOfWeek.put("Sun", DayOfWeek.SUNDAY);

        //Map<DayOfWeek,List<Interval>> mapOfDate = new HashMap<>();
        List<Interval> listOfSchedules = new ArrayList<>();

        String[] lines = S.split("\n");
        //parse
        for(String line : lines) {
            String dayOfWeekStr = line.substring(0,3).trim();
            String startHourStr = line.substring(4,6).trim();
            String startMinStr = line.substring(7,9).trim();
            String endHourStr = line.substring(10,12).trim();
            String endMinStr = line.substring(13,15).trim();

            DayOfWeek dayOfWeek = mapDayOfWeek.get(dayOfWeekStr);
            int start = Integer.parseInt(startHourStr) * 60 + Integer.parseInt(startMinStr);
            int end = Integer.parseInt(endHourStr) * 60 + Integer.parseInt(endMinStr);

            //multiply by the day of week
            start = dayOfWeek.ordinal() * 1440 + start;
            end = dayOfWeek.ordinal() * 1440 + end;

            //List<Interval> listOfSchedule = mapOfDate.getOrDefault(dayOfWeek, new ArrayList<>());
            listOfSchedules.add(new Interval(dayOfWeek, start, end));
        }

        int sleepInterval = 0;
        //calculate long period
        int start = 0;
        int end = 7 * 1440;
        if(listOfSchedules.isEmpty()){
            return end;
        } else {
            listOfSchedules.sort(Comparator.comparingInt(o -> o.start));
            for (Interval interval: listOfSchedules) {
                sleepInterval = Math.max(sleepInterval, interval.start - start);
                start = interval.end;
            }
            sleepInterval = Math.max(sleepInterval, end - start);
        }
        return sleepInterval;
    }

    public static void main(String[] args) {
        String S = "Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00";
        System.out.println(solution(S));
    }
}

