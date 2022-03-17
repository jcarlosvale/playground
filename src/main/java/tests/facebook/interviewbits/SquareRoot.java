package tests.facebook.interviewbits;

public class SquareRoot {

    public static int sqrt(int A) {
        if (A == 0) return 0;
        if (A == 1) return 1;
        return sqrt(A, 1, A/2);
    }

    public static int sqrt(int A, int start, int end) {
        if(start > end) return end;
        int mid = start + (end - start) / 2;
        long value = (long) mid * mid;
        if (value == A) return mid;
        if (value > A) {
            return sqrt(A, start, mid - 1);
        } else {
            return sqrt(A, mid+1, end);
        }
    }

    public static void main(String[] args) {
//        System.out.println(sqrt(4));
//        System.out.println(sqrt(10));
        System.out.println(sqrt(930675566)); //30506
    }
}
