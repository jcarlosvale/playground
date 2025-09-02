package ada;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(Arrays.stream(stones).boxed().toList());
        while(!pq.isEmpty()) {
            int stone1 = pq.poll();
            if (pq.isEmpty()) return stone1;
            int stone2 = pq.poll();
            int result = Math.abs(stone1 - stone2);
            if (result > 0) pq.add(result);
        }
        return 0;
    }
}
