package tests.leetcode.challenge30days.june;

import java.util.*;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is
 * costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        int [] diff = new int[costs.length];
        //maximum using A
        //calculating differences between B and A
        for (int i = 0; i < costs.length; i++) {
            cost += costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(diff);
        //pega as menores diferencas
        for(int i = 0; i < costs.length / 2; i++) {
            cost += diff[i];
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int [][] {
                {10,20},{30,200},{400,50},{30,20}
        })); //110
    }
}
