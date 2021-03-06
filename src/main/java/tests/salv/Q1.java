package tests.salv;

public class Q1 {

    public static boolean Solution(int[] A) {
        int posicaoCorrente = 0;

        if (A.length == 0)
            return true;

        while (posicaoCorrente < A.length && A[posicaoCorrente] != 0)
            posicaoCorrente += A[posicaoCorrente];

        return posicaoCorrente >= A.length;
    }

    public static void main(String[] args) {
        System.out.println(Solution(new int[] {3,0,3,1,0}));
    }
}
