package tests.facebook.preparation;

import java.util.PriorityQueue;

public class MagicalCandyBags {
    static int maxCandies(int[] arr, int k) {
        int ans = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //load priority queue
        for(int n : arr) {
            priorityQueue.add(n);
        }
        while(k > 0) {
            int value = priorityQueue.poll();
            ans += value;
            priorityQueue.add(value / 2);
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxCandies(new int[]{2, 1, 7, 4, 2}, 3)); //14
    }
}
