package tests.salt;

public class Task2 {

    public int solution(int[] A, int K, int L) {
        if ((K + L) > A.length) return -1;

        int greater, less;
        int value1 = -1, value2 = -1;
        if (K > L) {
            greater = K;
            less = L;
        }
        else {
            greater = L;
            less = K;
        }

        boolean [] used = new boolean[A.length];

        int index = -1;
        for (int i = 0; i < A.length; i++) {
            int temp = sum(A, i, greater);
            if (temp > value1) {
                value1 = temp;
                index = i;
            }
            if(temp < 0) break;
        }

        for (int i = index; i < index + greater - 1; i++) {
            used[i] = true;
        }

        external: for (int i = 0; i < A.length; i++) {
            //verify used
            for (int j = i; j < i + less - 1; j++) {
                if (used[j]) continue external;
            }

            int temp = sum(A, i, less);
            if (temp > value2) {
                value2 = temp;
            }
            if(temp < 0) break;
        }

        if ((value1 == -1) || (value2 == -1)) return -1;
        return value1 + value2;
    }

    private int sum(int[] a, int i, int numberOfElements) {
        if (i+numberOfElements > a.length) return -1;
        int value = 0;
        while(numberOfElements > 0) {
            value += a[i];
            i++;
            numberOfElements--;
        }
        return value;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        int [] A = {6,1,4,6,3,2,7,4};
        int K = 3;
        int L = 2;
        int solution = task2.solution(A, K, L);
        System.out.println(solution);
    }
}
