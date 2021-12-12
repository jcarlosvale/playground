package tests.zalando;

public class Q3 {
    public static int solution(int[] A) {
        int min1, min2 , min3;
        int index1, index2, index3;
        int a = 1, b = 2, c = 3;

        //6 possibilities
        if (satisfy(A, a, b, c)) {
            min1 = A[a]; min2 = A[b]; min3 = A[c];
            index1 = a; index2 = b; index3 = c;
        } else {
            a = 1; b = 3; c = 2;
            if (satisfy(A, a, b, c)) {
                min1 = A[a]; min2 = A[b]; min3 = A[c];
                index1 = a; index2 = b; index3 = c;
            } else {
                a = 2; b = 1; c = 3;
                if (satisfy(A, a, b, c)) {
                    min1 = A[a]; min2 = A[b]; min3 = A[c];
                    index1 = a; index2 = b; index3 = c;
                } else {
                    a = 2; b = 3; c = 1;
                    if (satisfy(A, a, b, c)) {
                        min1 = A[a]; min2 = A[b]; min3 = A[c];
                        index1 = a; index2 = b; index3 = c;
                    } else {
                        a = 3; b = 1; c = 2;
                        if (satisfy(A, a, b, c)) {
                            min1 = A[a]; min2 = A[b]; min3 = A[c];
                            index1 = a; index2 = b; index3 = c;
                        } else {
                            a = 3; b = 2; c = 1;
                            min1 = A[a]; min2 = A[b]; min3 = A[c];
                            index1 = a; index2 = b; index3 = c;
                        }
                    }
                }
            }
        }
        //verify last position
        for(int i = 4; i < A.length -1; i++) {
            int element = A[i];

            if(element <= min1) {
                min3 = min2;
                index3 = index2;

                min2 = min1;
                index2 = index1;

                min1 = element;
                index1 = i;
            } else {
                if(element <= min2) {
                    min3 = min2;
                    index3 = index2;

                    min2 = element;
                    index2 = i;
                } else {
                    if(element < min3) {
                        min3 = element;
                        index3 = i;
                    }
                }
            }
        }

        //retrieve not adjacent
        if (Math.abs(index1-index2)> 1) {
            return min1 + min2;
        } else {
            if (Math.abs(index1-index3)> 1) {
                return min1 + min3;
            } else {
                return min2 + min3;
            }
        }
    }

    private static boolean satisfy(int[] A, int a, int b, int c) {
        return A[a] <= A[b] && A[b] <= A[c];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,2,4,6,3,7})); //5
        System.out.println(solution(new int[]{5,4,3,2,1})); //6
        System.out.println(solution(new int[]{1,2,2,2,1})); //4
        System.out.println(solution(new int[]{1,2,1,3,1})); //5
    }
}
