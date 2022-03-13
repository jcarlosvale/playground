package tests.facebook.interviewbits;

import java.util.List;

public class BestTimeToBuyAndSellStocksI {
    public static int maxProfit(final List<Integer> A) {
        if (A.isEmpty()) return 0;
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int value : A) {
            min = Math.min(min, value);
            profit = Math.max(profit, value - min);
        }
        return profit;
    }
}
