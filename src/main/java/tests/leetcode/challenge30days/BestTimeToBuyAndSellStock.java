package tests.leetcode.challenge30days;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int diff;
        for (int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i-1];
            if (diff > 0) profit += diff;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
