package tests.trustly;

import java.util.*;

public class KPairsSmallestSum {
  
  /*
  Level: Senior
  
  You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

  Define a pair (u,v) which consists of one element from the first array and one element from the second array.
  
  Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
  
  Example 1:
    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    Output: [[1,2],[1,4],[1,6]] 
    Explanation: The first 3 pairs are returned from the sequence: 
                 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
  
  Example 2:
    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
    Output: [1,1],[1,1]
    Explanation: The first 2 pairs are returned from the sequence: 
                 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
  
  Example 3:
    Input: nums1 = [1,2], nums2 = [3], k = 3
    Output: [1,3],[2,3]
    Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
  
  Have a good test. :D
  */

  public static void main(String[] args) {
    System.out.println("Expected: [[1,2],[1,4],[1,6]]");
    System.out.println(String.format("Got: %s\n", solution(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3)));

    System.out.println("Expected: [[1,1],[1,1]]");
    System.out.println(String.format("Got: %s\n", solution(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2)));

    System.out.println("Expected: [[1,3],[2,3]");
    System.out.println(String.format("Got: %s\n", solution(new int[]{1, 2}, new int[]{3}, 3)));
  }


  private static List<List<Integer>> solution(int[] nums1, int[] nums2, int k) {
    Queue<List<Integer>> heap = new PriorityQueue<>((l1, l2) -> (l2.get(0) + l2.get(1)) - (l1.get(0) + l1.get(1)));

    for (int value : nums1) {
      for (int i : nums2) {
        heap.add(Arrays.asList(value, i));
        if (heap.size() > k) {
          heap.poll();
        }
      }
    }

    List<List<Integer>> list = new ArrayList<>();
    while (!heap.isEmpty()) {
      list.add(heap.poll());
    }

    return list;
  }
}