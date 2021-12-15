package tests.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Songs {

    public static List<Integer> findSongs(int rideDuration, List<Integer> songDurations) {
        int exactMin = rideDuration - 30;

        //calculate dif
        Map<Integer, Integer> containsMap = new HashMap<>();
        for(int i = 0; i < songDurations.size(); i++) {
            int diff = exactMin - songDurations.get(i);
            if(diff < 0) continue;
            if(containsMap.containsKey(diff)) {
                List<Integer> selectedMusics = new ArrayList<>();
                selectedMusics.add(containsMap.get(diff));
                selectedMusics.add(i);
                return selectedMusics;
            } else {
                containsMap.put(diff, i);
            }
        }

        List<Integer> list =new ArrayList<>();
        list.add(-1);
        list.add(-1);
        return list;
    }
}
