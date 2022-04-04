package tests.amazon;

import java.util.List;

public class Imbalance {
    public static long findTotalImbalance(List<Integer> rank) {
        // Write your code here
        long ans = 0;
        for (int i = 0; i < rank.size() - 1; i++) {
            ans += Math.abs(rank.get(i) - rank.get(i+1)) - 1;
        }
        return ans;
    }


    public static long findTotalImbalance2(List<Integer> rank) {
        // Write your code here
        boolean[] array = new boolean[rank.size()+1];
        long ans = 0;
        int count = 0;
        for (int i = 0; i < rank.size(); i++) {
            count = i + 1;
            int index = rank.get(i);
            array[index] = true;
            if(count > 1) {
                if (index == rank.size()) {
                    if (!array[index+1]) {
                        ans += 1 + ans;
                    }
                }
                if (index != 1) {
                    if (!array[index+1] || !array[index-1]) {
                        ans += 1 + ans;
                    }
                } else {
                    if (!array[index+1]) {
                        ans += 1 + ans;
                    }
                }
            }
        }
        return ans;
    }
}

