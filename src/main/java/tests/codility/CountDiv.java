package tests.codility;

public class CountDiv {
    public int solution(int A, int B, int K) {
        if(A == B) {
            if (A%K == 0) return 1;
            else return 0;
        }
        int min = (A % K == 0) ? A/K : A/K + 1;
        int max = B/K;
        return max - min + 1;
    }
}
