package tests.tipico;

public class Q2 {
    public static int solution(int[] A, int [] B) {
        int count = 0;
        long sum1 = 0, sum2 = 0;
        long subSum1 = 0, subSum2 = 0;
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
            sum2 += B[i];
        }
        for (int i = 0; i < A.length-1; i++) {
            subSum1 += A[i];
            subSum2 += B[i];
            long value1 = subSum1;
            long value2 = subSum2;
            long value3 = sum1 - subSum1;
            long value4 = sum2 - subSum2;
            if ((value1 == value2) && (value1 == value3) && (value1 == value4)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {0,4,-1,0,3}, new int[]{0,-2,5,0,3}));  //2
        System.out.println(solution(new int[] {2,-2,-3,3}, new int[]{0,0,4,-4}));  //1
        System.out.println(solution(new int[] {4,-1,0,3}, new int[]{-2,6,0,4}));  //0
        System.out.println(solution(new int[] {3,2,6}, new int[]{4,1,6}));  //0
        System.out.println(solution(new int[] {1,4,2,-2,5}, new int[]{7,-2,-2,2,5}));  //2
    }
}
