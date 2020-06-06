package tests.leetcode.challenge30days.june;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
 * Random Pick with Weight
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex
 * which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the
 * array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class RandomPickWithWight {

    private double[] weights;
    public RandomPickWithWight(int[] w) {
        normalize(w);
    }

    private void normalize(int [] w) {
        double sum = 0;
        for (int value: w) {
            sum += value;
        }
        weights = new double[w.length];
        for (int i = 0; i < w.length; i++) {
            weights[i] = w[i] / sum;
            if (i > 0) {
                weights[i] = weights[i-1] + weights[i];
            }
        }
    }

    public int pickIndex() {
        double rand = Math.random();
        int selected = -1;
        for (int i = 0; i < weights.length; i++) {
            if(rand <= weights[i]) {
                selected = i;
                break;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        RandomPickWithWight randomPickWithWight = new RandomPickWithWight(new int[]{5,4});
        for (int i = 0; i < 9; i++) {
            System.out.println(randomPickWithWight.pickIndex());
        }
        System.out.println("****");
        randomPickWithWight = new RandomPickWithWight(new int[]{188, 927, 949, 95, 151, 659, 405, 906, 481, 363, 728, 839});
        for (int i = 0; i < 9; i++) {
            System.out.println(randomPickWithWight.pickIndex());
        }

    }
}
