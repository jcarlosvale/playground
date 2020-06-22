package tests.leetcode.challenge30days.june;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at
 * least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 *              received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note:
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * Follow up:
 *
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 *    Hide Hint #1
 * Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class HIndexII {
    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations.length == 1 && citations[0] == 0) {
            return 0;
        }
        return binarySearch(citations, 0, citations.length-1);
    }

    private static int binarySearch(int[] citations, int start, int end) {
        if (start > end) {
            return citations.length - start;
        }
        int middle = start + (end-start) / 2;
        int h = citations[middle];
        int distance = citations.length - middle;
        if (h == distance) {
            return h;
        }
        if (h < distance) {
            int h1 = binarySearch(citations, middle+1, end);
            if (h1 <= distance) {
                return h1;
            } else {
                return h;
            }
        } else {
            return binarySearch(citations, start, middle-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0,1,3,5,6})); //3
        System.out.println(hIndex(new int[]{10,10,10})); //3
        System.out.println(hIndex(new int[]{1,3,10,10,10})); //3
        System.out.println(hIndex(new int[]{1,2,3,10,10,10})); //3

    }
}
