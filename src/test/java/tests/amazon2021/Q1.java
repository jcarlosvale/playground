package tests.amazon2021;

import java.util.*;
import java.util.stream.Collectors;

public class Q1 {

    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<Integer, Integer> countTransactions = new HashMap<>();
        for(String log: logs) {
            String[] logInfo = log.split(" ");
            int sender = Integer.parseInt(logInfo[0]);
            int receiver = Integer.parseInt(logInfo[1]);
            if(sender == receiver) {
                countTransactions.put(sender, countTransactions.getOrDefault(sender, 0) + 1);
            } else {
                countTransactions.put(sender, countTransactions.getOrDefault(sender, 0) + 1);
                countTransactions.put(receiver, countTransactions.getOrDefault(receiver, 0) + 1);
            }
        }
        //filter
        List<Integer> users = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : countTransactions.entrySet()) {
            if(entry.getValue() >= threshold) {
                users.add(entry.getKey());
            }
        }
        //sort
        Collections.sort(users);
        //return
        return users.stream().map(String::valueOf).collect(Collectors.toList());
    }
}
