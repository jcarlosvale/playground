package ada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> b.num() - a.num());
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            if(i == 0) {
                for(i = 0; i < k; i++) {
                    pq.add(new Element(nums[i], i));
                }
                result.add(pq.peek().num());
            } else {
                pq.add(new Element(nums[i], i));
                Element candidate = pq.peek();
                while(candidate.index() <= i - k) {
                    pq.poll();
                    candidate = pq.peek();
                }
                result.add(candidate.num());
                i++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}

record Element(int num, int index){}


