package tests.vanhack;

import java.util.*;

public class MeetupSchedule {

    /*
     * Complete the 'countMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY firstDay
     *  2. INTEGER_ARRAY lastDay
     */

    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> mapOfInvestorByDuration = new TreeMap<>();
        int maxDay = Integer.MIN_VALUE;
        int minDay = Integer.MAX_VALUE;
        //iterate over each investor and fill the map
        for (int i = 0; i < firstDay.size(); i++) {
            int start = firstDay.get(i);
            int end = lastDay.get(i);
            if (start < minDay) minDay = start;
            if (end > maxDay) maxDay = end;
            int duration = end-start;
            if (mapOfInvestorByDuration.containsKey(duration)) {
                TreeMap<Integer, List<Integer>> mapStart = mapOfInvestorByDuration.get(duration);
                List<Integer> listStart = mapStart.get(start);
                if (listStart == null) {
                    listStart = new ArrayList<>();
                }
                listStart.add(i);
                mapStart.put(start, listStart);
            } else {
                TreeMap<Integer, List<Integer>> mapStart = new TreeMap<>();
                List<Integer> listStart = new ArrayList<>();
                listStart.add(i);
                mapStart.put(start, listStart);
                mapOfInvestorByDuration.put(duration,mapStart);
            }
        }
        //iterate by duration
        int cont = 0;
        int [] schedules = new int[maxDay-minDay+1];
        Arrays.fill(schedules,-1);

        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entryMapDuration : mapOfInvestorByDuration.entrySet()) {
            for(Map.Entry<Integer, List<Integer>> entryMapStart : entryMapDuration.getValue().entrySet()) {
                int start = entryMapStart.getKey();
                int duration = entryMapDuration.getKey();
                List<Integer> listInvestor = entryMapStart.getValue();
                int index = start - minDay;
                for(Integer investor : listInvestor) {
                    if(schedules[index] == -1) {
                        schedules[index] = investor;
                        cont++;
                        if(cont  >= maxDay-minDay+1) return maxDay-minDay+1;
                        if(cont >= firstDay.size()) return firstDay.size();
                    } else {
                        while(duration > 0) {
                            index++;
                            duration --;
                            if(schedules[index] == -1) {
                                schedules[index] = investor;
                                cont++;
                            }
                            if(cont  >= maxDay-minDay+1) return maxDay-minDay+1;
                            if(cont >= firstDay.size()) return firstDay.size();
                        }
                    }
                }
            }
        }
        return cont;
    }

    public static void main(String[] args) {
        System.out.println(countMeetings(List.of(1,2,3,3,3), List.of(2,2,3,4,4)));
        System.out.println(countMeetings(List.of(1,2,1,2,2), List.of(3,2,1,3,3)));
    }
}
