package tests.facebook;

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
        int count = 0;
        int [] [] PAB = new int [3][N];
        int [] [] BAP = new int [3][N];
        char[] characters = C.toCharArray();

        //PAB
        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (i > 0) PAB[0][i] += PAB[0][i-1];
            if (c == 'P') {
                int start = i + X;
                int end = i + Y;
                if(start < N) {
                    PAB[0][start] += 1;
                }
                if (end + 1 < N) {
                    PAB[0][end+1] += -1;
                }
            } else {
                if (c == 'B') PAB[2][i] = 1;
            }
        }

        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (c == 'A') {
                if(PAB[0][i] > 0) {
                    int start = i + X;
                    int end = i + Y;
                    if(start < N) {
                        PAB[1][start] += 1;
                    }
                    if (end + 1 < N) {
                        PAB[1][end+1] += -1;
                    }
                }
            } else {
                if (i > 0) PAB[1][i] += PAB[1][i-1];
            }
        }

        //BAP
        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (c == 'B') {
                int start = i + X;
                int end = i + Y;
                if(start < N) {
                    BAP[0][start] += 1;
                }
                if (end + 1 < N) {
                    BAP[0][end+1] += -1;
                }
            } else {
                if (c == 'P') BAP[2][i] = 1;
                if (i > 0) BAP[0][i] += BAP[0][i-1];
            }
        }

        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (i > 0) BAP[1][i] += BAP[1][i-1];
            if (c == 'A') {
                if(BAP[0][i] > 0) {
                    int start = i + X;
                    int end = i + Y;
                    if(start < N) {
                        BAP[1][start] += 1;
                    }
                    if (end + 1 < N) {
                        BAP[1][end+1] += -1;
                    }
                }
            }
        }
        //prefixed sum
        //sum(BAP);

        //calculation
        for (int i = 0; i < N; i++) {
            count += PAB[0][i] * PAB[1][i] * PAB[2][i];
            count += BAP[0][i] * BAP[1][i] * BAP[2][i];
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getArtisticPhotographCount(5, "APABA", 1, 2));    //1
        System.out.println(getArtisticPhotographCount(5, "APABA", 2, 3));    //0
        System.out.println(getArtisticPhotographCount(8, ".PBAAP.B", 1, 3)); //3
        System.out.println(getArtisticPhotographCount(5, "PPABB", 1, 4)); //4
    }

}