package tests.salt;

import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Task1 {

    //00:01:07,400-234-090
    private class Call {
        String number;
        String duration;
        LocalTime durationTime;

        //"hh:mm:ss,nnn-nnn-nnn"
        Call(String line) {
            String[] data = line.split(",");
            duration = data[0];
            number = data[1];
            durationTime = LocalTime.parse(duration);
        }

        public long durationInSeconds() {
            long seconds = 0;
            seconds += durationTime.getMinute() * 60;
            seconds += durationTime.getHour() * 3600;
            seconds += durationTime.getSecond();
            return seconds;
        }

        public long costDuration() {
            long minutes = 0;
            minutes += durationTime.getMinute();
            minutes += durationTime.getHour() * 60;
            if (minutes >= 5) {
                if (durationTime.getSecond() > 0) {
                    minutes += 1;
                }
            } else {
                long seconds = minutes * 60;
                seconds += durationTime.getSecond();
                return seconds * 3;
            }
            return minutes * 150;
        }

        @Override public String toString() {
            return "Call{" + "number='" + number + '\'' + ", duration='" + duration + '\'' + '}';
        }
    }



    public int solution(String S) {
        String[] calls = S.split("\n");
        Map<String, Long> mapCall = new HashMap<>();
        Map<String, Long> mapCosts = new HashMap<>();
        //calculate durations of each call number
        for (int i = 0; i < calls.length; i++) {
            Call call = new Call(calls[i]);
            if (mapCall.containsKey(call.number)) {
                Long durationSeconds = mapCall.get(call.number);
                mapCall.put(call.number, durationSeconds + call.durationInSeconds());
                mapCosts.put(call.number, call.costDuration() + mapCosts.get(call.number));
            } else {
                mapCall.put(call.number, call.durationInSeconds());
                mapCosts.put(call.number, call.costDuration());
            }
        }
        //sort by duration
        Optional<Map.Entry<String, Long>> callToRemove = mapCall.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst();

        //calculate cost
        String removeFromCost = callToRemove.get().getKey();
        mapCosts.remove(removeFromCost);
        int cost = 0;
        for (Long value : mapCosts.values()) {
            cost += value;
        }
        return cost;
    }

    public static void main(String[] args) {

        Task1 task1 = new Task1();
        /*Task1.Call call = task1.new Call("00:05:01,400-234-090");
        System.out.println(call);
        System.out.println(call.durationInMinutes());
        LocalTime localTime1 = LocalTime.parse("01:01:59");
        LocalTime localTime2 = LocalTime.parse("01:59:01");
        Duration d = Duration.between(LocalTime.MIDNIGHT, localTime2);
        System.out.println(localTime1.plus(d));

         */
        String S = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
        System.out.println(task1.solution(S));
    }


}
