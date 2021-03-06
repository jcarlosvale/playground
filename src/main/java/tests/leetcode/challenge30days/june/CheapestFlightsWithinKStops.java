package tests.leetcode.challenge30days.june;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to
 * find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 *
 * Constraints:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */

/**
 * NOT SOLVED, READ BELLMAN FORD: https://github.com/cherryljr/LeetCode/blob/master/Cheapest%20Flights%20Within%20K%20Stops.java
 */
public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dp = new int[n + 1];
        final int MAX = 0x3f3f3f3f;  //infinity
        Arrays.fill(dp, MAX);
        dp[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] temp = new int[n + 1];
            System.arraycopy(dp, 0, temp, 0, n + 1);
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], cost = flight[2];
                temp[v] = Math.min(temp[v], dp[u] + cost);
            }
            dp = temp;
        }
        return dp[dst] == MAX ? -1 : dp[dst];
    }

    public static void main(String[] args) {
        //System.out.println(findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1)); //200
        //System.out.println(findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,0)); //500
        System.out.println(findCheapestPrice(4,new int[][]{{0,1,1},{0,2,5},{1,2,1}, {2,3,1}},0,3,1)); //6
    }
}
