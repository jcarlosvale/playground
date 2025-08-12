package ada;

import java.util.PriorityQueue;

public class Pile {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int gift : gifts) {
            pq.offer(gift);
        }
        for(int i = 0; i < k; i++) {
            int maxGift = pq.poll();
            int newGift = (int) Math.floor(Math.sqrt(maxGift));
            pq.offer(newGift);
        }
        return pq.stream().mapToInt(gift->gift).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Pile().pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
    }
}
