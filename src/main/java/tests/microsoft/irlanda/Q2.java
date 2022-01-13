package tests.microsoft.irlanda;

public class Q2 {
    public static int solution(int[] A) {
        int HIGHER = 1_000_000_000;
        long counter = 0;

        //3 elements case
        if (A.length == 1) {
            counter = A[0];
        } else {
            if (A.length == 2) {
                counter =  Math.max(A[0], A[1]);
            } else {
                int max = 0;
                int countBlocks = 0;
                //identify MAX
                for (int i = 0; i < A.length - 2; i++) {

                    int start = A[i];
                    int middle = A[i+1];
                    int end = A[i+2];

                    max = Math.max(Math.max(max,start), Math.max(middle, end));
                    if (max >= HIGHER) return -1;

                    if(middle - start > 0 && end - middle < 0) {
                        countBlocks++;
                    }
                }
                counter = max + countBlocks;
            }
        }

        if (counter >= HIGHER) return -1;

        return (int) counter;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2})); //9
        System.out.println(solution(new int[]{5, 5, 5})); //5
        System.out.println(solution(new int[]{5, 5, 1_000_000_000})); //-1

    }
}
