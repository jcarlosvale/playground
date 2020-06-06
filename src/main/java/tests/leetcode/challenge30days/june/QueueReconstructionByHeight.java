package tests.leetcode.challenge30days.june;

import java.util.*;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h,
 * k), where h is the height of the person and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 *    Hide Hint #1
 * What can you say about the position of the shortest person?
 * If the position of the shortest person is i, how many people would be in front of the shortest person?
 *    Hide Hint #2
 * Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
 */
public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<Integer>> mapPeople = new TreeMap<>();
        int[][] queue = new int[people.length][2];
        //initialize
        for (int i = 0; i < queue.length; i++) {
            queue[i][0] = -1;
        }
        //counter
        for (int i = 0; i < people.length; i++) {
            int height = people[i][0];
            int inFront = people[i][1];
            List<Integer> list = mapPeople.getOrDefault(height, new ArrayList<>());
            list.add(inFront);
            mapPeople.put(height, list);
        }
        //fill queue
        for (int height: mapPeople.keySet()) {
            for (int inFront: mapPeople.get(height)) {
                int copyInFront = inFront;
                for (int i = 0; i < queue.length; i++) {
                    if (queue[i][0] == -1 || queue[i][0] >= height) { //empty or higher
                        inFront--;
                        if (inFront < 0) {
                            queue[i][0] = height;
                            queue[i][1] = copyInFront;
                            break;
                        }
                    }
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}))); //[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    }

}
