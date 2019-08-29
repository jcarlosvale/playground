package tests.microsoft;

public class TurnBubs2 {

    public static int solution(int[] A) {
        long sumIndex = 0;
        long sumElements = 0;
        int shine = 0;
        for(int i = 0; i< A.length ; i++) {
            sumIndex += i+1;
            sumElements += A[i];
            if (sumElements == sumIndex) shine++;
        }
        return shine;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,1,3,5,4}));
        System.out.println(solution(new int[] {2,3,4,1,5}));
        System.out.println(solution(new int[] {1,3,4,2,5}));
    }
}
