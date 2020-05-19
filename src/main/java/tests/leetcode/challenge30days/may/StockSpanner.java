package tests.leetcode.challenge30days.may;

import java.util.*;

/**
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's
 * price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and
 * going backwards) for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans
 * would be [1, 1, 1, 2, 1, 4, 6].
 *
 *
 *
 * Example 1:
 *
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 *
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 */
public class StockSpanner {

    private Deque<int []> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int spanValue = 1;
        int [] values = new int[2];
        values[0] = price;
        values[1] = spanValue;
        if (!stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                values[1] += stack.pop()[1];
            }
        }
        stack.push(values);
        return values[1];
    }

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
/*
        System.out.println(S.next(100));// is called and returns 1,
        System.out.println(S.next(80));// is called and returns 1,
        System.out.println(S.next(60));// is called and returns 1,
        System.out.println(S.next(70));// is called and returns 2,
        System.out.println(S.next(60));// is called and returns 1,
        System.out.println(S.next(75));// is called and returns 4,
        System.out.println(S.next(85));// is called and returns 6.
*/
        String [] instructions = {"StockSpanner","next","next","next","next","next"};
        Integer [] values = {null,29,91,62,76,51};
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < instructions.length; i++) {
            switch (instructions[i]) {
                case "StockSpanner":
                    S = new StockSpanner();
                    break;
                case "next":
                    result.add(S.next(values[i]));
                    break;
            }
        }
        System.out.println(result); //[null,1,2,1,2,1]

        instructions = new String[]{"StockSpanner","next","next","next","next","next","next","next","next","next","next"};
        values = new Integer[] {null,28,14,28,35,46,53,66,80,87,88};
        result = new ArrayList<>();
        for (int i = 0; i < instructions.length; i++) {
            switch (instructions[i]) {
                case "StockSpanner":
                    S = new StockSpanner();
                    break;
                case "next":
                    result.add(S.next(values[i]));
                    break;
            }
        }
        System.out.println(result); //[null,1,1,3,4,5,6,7,8,9,10]

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
