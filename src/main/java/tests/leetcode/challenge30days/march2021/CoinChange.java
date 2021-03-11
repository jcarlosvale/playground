package tests.leetcode.challenge30days.march2021;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int [] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= amount ; i++) {
            for(int j = coins.length-1; j >= 0; j--){
                int coin = coins[j];
                if(i == coin) {
                    dp[i] = 1;
                } else {
                    if (i > coin) {
                        if(dp[i-coin] == Integer.MAX_VALUE) continue;
                        dp[i]  = Math.min(dp[i-coin] + 1, dp[i]);
                    }
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1,2,5},11)); //3
//        System.out.println(coinChange(new int[]{2},3)); //-1
//        System.out.println(coinChange(new int[]{1},0)); //0
//        System.out.println(coinChange(new int[]{1},1)); //1
//        System.out.println(coinChange(new int[]{1},2)); //2
        System.out.println(coinChange(new int[]{186, 419, 83, 408},6249)); //20
    }
}
