package ada;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxScoreAfterKOperation {
    public static long maxKelements(int[] nums, int k) {
        int score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(nums).forEach(pq::offer);

        while(k > 0) {
            int value = pq.poll();
            score += value;
            value = (int) Math.ceil(value / 3.0);
            pq.offer(value);
            k--;
        }

        return score;
    }

    public static void main(String[] args) {
     //   System.out.println(maxKelements(new int[]{10, 10, 10}, 2)); // Output: 20
        System.out.println(maxKelements(new int[]{1,10,3,3,3}, 3)); // Output: 17
    }
}
