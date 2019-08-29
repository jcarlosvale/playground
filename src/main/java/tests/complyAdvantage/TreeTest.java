package tests.complyAdvantage;

public class TreeTest {

    public int solution(int[] A) {
        int n = A.length;
        if (n == 1) return 0;
        if (n == 2) {
            if (A[0] == A[1]) return 1;
            else return 0;
        }
        if (aesthetically(A)) return 0;
        return Math.min(caseStartUp(A.clone(), true), caseStartUp(A.clone(), false));
    }

    private int caseStartUp(int[] A, boolean isUp) {
        int cut = 0;
        for (int i = 0; i < A.length-1; i++) {
            int value1 = A[i];
            int value2 = A[i+1];
            if (isUp) {
                if (isDown(value1, value2)) {
                    A[i] = A[i+1] - 1;
                    cut++;
                }
            } else {
                if (isUp(value1, value2)) {
                    if (A.length > i+2) {//exist next
                        A[i+1] = A[i+2] - 1;
                    }
                    cut++;
                }
            }
            isUp = !isUp;
        }
        return cut;
    }

    private boolean aesthetically(int[] A) {
        boolean prevIsUp = isUp(A[0], A[1]);
        for (int i = 1; i < A.length-1; i++) {
            int value1 = A[i];
            int value2 = A[i+1];
            if (prevIsUp) {
                if (!(isDown(value1,value2))) return false;
            } else {
                if (!(isUp(value1,value2))) return false;
            }
            prevIsUp = !prevIsUp;
        }
        return true;
    }



    private boolean isDown(int value1, int value2) {
        return value2 <  value1;
    }

    private boolean isUp(int value1, int value2) {
        return value2 >  value1;
    }


    public static void main(String[] args) {
        TreeTest test = new TreeTest();
        System.out.println(test.solution(new int[] {3, 7, 4, 5}));
    }
}
