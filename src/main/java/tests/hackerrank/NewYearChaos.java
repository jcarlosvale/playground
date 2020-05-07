package tests.hackerrank;

/**
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people
 * queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions
 * increment by  from  at the front of the line to  at the back.
 *
 * Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap
 * positions, they still wear the same sticker denoting their original places in line. One person can bribe at most
 * two others. For example, if  and  bribes , the queue will look like this: .
 *
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the
 * queue into its current state!
 *
 * Function Description
 *
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number
 * of bribes necessary, or Too chaotic if the line configuration is not possible.
 *
 * minimumBribes has the following parameter(s):
 *
 * q: an array of integers
 * Input Format
 *
 * The first line contains an integer , the number of test cases.
 *
 * Each of the next  pairs of lines are as follows:
 * - The first line contains an integer , the number of people in the queue
 * - The second line has  space-separated integers describing the final state of the queue.
 *
 * Constraints
 *
 * Subtasks
 *
 * For  score
 * For  score
 *
 * Output Format
 *
 * Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too
 * chaotic if the state is invalid, i.e. it requires a person to have bribed more than  people.
 *
 * Sample Input
 *
 * 2
 * 5
 * 2 1 5 3 4
 * 5
 * 2 5 1 3 4
 * Sample Output
 *
 * 3
 * Too chaotic
 */
public class NewYearChaos {
    static void minimumBribes(int[] q) {
        int originalPos = -1;
        int minimumBribes = 0;
        int countChanges = 0;
        for (int i = 0; i < q.length; i++) {
            originalPos = q[i];
            int diffPosition = i - (originalPos - 1);
            if (diffPosition < -2) {
                minimumBribes = -1;
                break;
            } else {
                if (diffPosition < 0) {
                    minimumBribes += -(diffPosition);
                    countChanges++; //maximum changes in the sequence positions
                }
                if (diffPosition > 0) {
                    if (diffPosition > countChanges) {
                        minimumBribes += diffPosition - countChanges;
                    }
                }
            }
        }
        if (minimumBribes < 0) {
            System.out.println("Too chaotic");
        } else{
            System.out.println(minimumBribes);
        }
    }

    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4}); //3
        minimumBribes(new int[]{2, 5, 1, 3, 4}); //Too chaotic
        minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4}); //Too chaotic
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); //7

    }
}
