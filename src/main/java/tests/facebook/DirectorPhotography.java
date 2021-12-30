package tests.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * A photography set consists of NN cells in a row, numbered from 11 to NN in order, and can be represented by a string CC of length NN. Each cell ii is one of the following types (indicated by C_iC
 * i
 * ​
 *  , the iith character of CC):
 * If C_iC
 * i
 * ​
 *   = “P”, it is allowed to contain a photographer
 * If C_iC
 * i
 * ​
 *   = “A”, it is allowed to contain an actor
 * If C_iC
 * i
 * ​
 *   = “B”, it is allowed to contain a backdrop
 * If C_iC
 * i
 * ​
 *   = “.”, it must be left empty
 * A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell, and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic if the distance between the photographer and the actor is between XX and YY cells (inclusive), and the distance between the actor and the backdrop is also between XX and YY cells (inclusive). The distance between cells ii and jj is |i - j|∣i−j∣ (the absolute value of the difference between their indices).
 * Determine the number of different artistic photographs which could potentially be taken at the set. Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.
 * Constraints
 * 1 \le N \le 2001≤N≤200
 * 1 \le X \le Y \le N1≤X≤Y≤N
 * Sample test case #1
 * N = 5
 * C = APABA
 * X = 1
 * Y = 2
 * Expected Return Value = 1
 * Sample test case #2
 * N = 5
 * C = APABA
 * X = 2
 * Y = 3
 * Expected Return Value = 0
 * Sample test case #3
 * N = 8
 * C = .PBAAP.B
 * X = 1
 * Y = 3
 * Expected Return Value = 3
 * Sample Explanation
 * In the first case, the absolute distances between photographer/actor and actor/backdrop must be between 11 and 22. The only possible photograph that can be taken is with the 33 middle cells, and it happens to be artistic.
 * In the second case, the only possible photograph is again taken with the 33 middle cells. However, as the distance requirement is between 22 and 33, it is not possible to take an artistic photograph.
 * In the third case, there are 44 possible photographs, illustrated as follows:
 * .P.A...B
 * .P..A..B
 * ..BA.P..
 * ..B.AP..
 * All are artistic except the first, where the artist and backdrop exceed the maximum distance of 3.
 */
class DirectorPhotography {
    public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
        int ct = 0;
        // left part of sliding window
        Map<Character, Long> left = new HashMap<>();
        left.put('B', 0L);
        left.put('P', 0L);

        // right part of sliding window
        Map<Character, Long> right = new HashMap<>();
        right.put('B', 0L);
        right.put('P', 0L);

        // find an A
        int i = 0;
        while(i < N && C.charAt(i) != 'A') i++;
        if (i == N) return 0;

        // initialize left part of sliding window
        for(int j = X; j <= Y && i-j >=0; j++) {
            left.computeIfPresent(C.charAt(i-j), (character, aLong) -> aLong+1);
        }

        // initialize right part of sliding window
        for(var j = X; j <= Y && i+j < N; j++) {
            right.computeIfPresent(C.charAt(i+j), (character, aLong) -> aLong+1);
        }

        // slide the window
        while(i < N)
        {
            if (C.charAt(i) == 'A') {
                // compute number of artistic photographs within the window
                ct += left.get('P')*right.get('B')+left.get('B')*right.get('P');
            }

            // left part remove and append character as we slide the window
            if (i - Y >= 0) left.computeIfPresent(C.charAt(i - Y), (character, aLong) -> aLong-1);
            if (i - X + 1 >= 0) left.computeIfPresent(C.charAt(i - X + 1), (character, aLong) -> aLong+1);

            // right part remove and append character as we slide the window
            if (i + X < N) right.computeIfPresent(C.charAt(i + X), (character, aLong) -> aLong-1);
            if (i + Y + 1 < N) right.computeIfPresent(C.charAt(i + Y + 1), (character, aLong) -> aLong+1);

            i++;
        }

        return ct;
    }

    public static void main(String[] args) {
        System.out.println(getArtisticPhotographCount(5, "APABA", 1, 2));    //1
        System.out.println(getArtisticPhotographCount(5, "APABA", 2, 3));    //0
        System.out.println(getArtisticPhotographCount(8, ".PBAAP.B", 1, 3)); //3
        System.out.println(getArtisticPhotographCount(5, "PPABB", 1, 4)); //4
    }

}