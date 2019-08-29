package tests.microsoft;

public class TurnBulbs {

    public static int solution(int[] A) {
        boolean [] turnOn = new boolean[A.length+1];
        turnOn[0] = true;
        int cont = 0;
        for (int i: A) {
            turnOn[i] = true;
            cont = cont + verifyTurnOn(turnOn, i-1);
        }
        return cont;
    }

    private static int verifyTurnOn(boolean[] turnOn, int j) {
        for (int i = 0; i<=j; i++) {
            if (!turnOn[i]) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,1,3,5,4}));
        System.out.println(solution(new int[] {2,3,4,1,5}));
        System.out.println(solution(new int[] {1,3,4,2,5}));

    }
}
