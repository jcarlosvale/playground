package tests.trustly;

/*
  Level: Middle

  Given a sorted list of integers called 'ints' in ascending order, count how many jumps you need to do to find the target value.
  Could you write an algorithm with O(log n) runtime complexity?

  Example 1:
  Input: nums = [5,7,8,10,13,20,22], target = 20
  Output: 2

  Example 2:
  Input: nums = [1,2,3,4,6,7,8,9], target = 1
  Output: 4

  Example 3:
  Input: nums = [12,34,55,63,79,99,100], target = 63
  Output: 1

  Constraints:
    1 < ints.size() < 10^8
    0 <= ints.get(i) < 10_000
 */

import java.util.Arrays;
import java.util.List;

public class CountJumpsToTarget {

  public static void main(String[] args) {
    System.out.println(solution(Arrays.asList(5, 7, 8, 10, 13, 20, 22), 20, 0)); //2
    System.out.println(solution(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9), 1, 0)); //4
    System.out.println(solution(Arrays.asList(12, 34, 55, 63, 79, 99, 10), 63, 0)); //1
  }

  private static int solution(List<Integer> ints, int target, int count) {
    count++;
    int mid = ints.size() / 2;
    if (ints.get(mid) > target) {
      return solution(ints.subList(0, mid), target, count);
    } else if (ints.get(mid) < target) {
      return solution(ints.subList(mid + 1, ints.size()), target, count);
    } else {
      return count;
    }
  }

}