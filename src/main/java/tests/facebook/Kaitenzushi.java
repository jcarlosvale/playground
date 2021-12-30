package tests.facebook;

import java.util.HashMap;
import java.util.Map;

class Kaitenzushi {
  
  public static int getMaximumEatenDishCount(int N, int[] D, int K) {
    Map<Integer, Integer> eatenMap = new HashMap<>();
    int count = 0;
    for (int i = 0; i < N; i++) {
      int dish = D[i];
      if ((count+1) - eatenMap.getOrDefault(dish, i-(N+1)) > K){
        count++;
        eatenMap.put(dish, count);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(getMaximumEatenDishCount(6, new int[]{1, 2, 3, 3, 2, 1}, 1)); //5
    System.out.println(getMaximumEatenDishCount(6, new int[]{1, 2, 3, 3, 2, 1}, 2)); //4
    System.out.println(getMaximumEatenDishCount(7, new int[]{1, 2, 1, 2, 1, 2, 1}, 2)); //2
  }
  
}