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
        TreeMap<Integer, List<Integer>> mapOfInvestorByDay = new TreeMap<>();
        //iterate over each investor and fill the map
        for (int i = 0; i < firstDay.size(); i++) {
            int start = firstDay.get(i);
            int end = lastDay.get(i);
            while(start <= end) {
                if (mapOfInvestorByDay.containsKey(start)) {
                    mapOfInvestorByDay.get(start).add(i);
                } else {
                    List<Integer> investorAvailableList = new ArrayList<>();
                    investorAvailableList.add(i);
                    mapOfInvestorByDay.put(start, investorAvailableList);
                }
                start ++;
            }
        }
        //iterate day by day
        int startDay = mapOfInvestorByDay.firstKey();
        int endDay = mapOfInvestorByDay.lastKey();
        int maxResult = endDay - startDay + 1;
        List<Set<Integer>> listOfCandidates = new ArrayList<>();
        for(int day = startDay; day <= endDay; day++) {
            List<Integer> listOfAvailableInvestors = mapOfInvestorByDay.get(day);
            List<Set<Integer>> currentListOfCandidates = new ArrayList<>();
            if (listOfAvailableInvestors != null) {
                for(int availableInvestor : listOfAvailableInvestors) {
                    if (listOfCandidates.isEmpty()) {
                        Set<Integer> currentSet = new HashSet<>();
                        currentSet.add(availableInvestor);
                        currentListOfCandidates.add(currentSet);
                        if (currentSet.size() == maxResult) return maxResult;
                    } else {
                        for(Set<Integer> candidate : listOfCandidates) {
                            Set<Integer> currentSet = new HashSet<>(candidate);
                            currentSet.add(availableInvestor);
                            currentListOfCandidates.add(currentSet);
                            if (currentSet.size() == maxResult) return maxResult;
                        }
                    }
                }
            }
            listOfCandidates = currentListOfCandidates;
        }
        //didn't find the maximum
        int max = 0;
        for(Set<Integer> candidate: listOfCandidates) {
            if (candidate.size() > max) max = candidate.size();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(countMeetings(List.of(1,2,3,3,3), List.of(2,2,3,4,4)));
        System.out.println(countMeetings(List.of(1,2,1,2,2), List.of(3,2,1,3,3)));

    }
}
