package tests.facebook.interviewbits;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffKII {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int diffPossible(final List<Integer> A, int B) {
        Set<Integer> expectedValues = new HashSet<>();
        Set<Integer> evaluatedValues = new HashSet<>();
        for(int i = 0; i < A.size(); i++) {
            if (expectedValues.contains(A.get(i)) || evaluatedValues.contains(B + A.get(i))) {
                return 1;
            }
            expectedValues.add(B + A.get(i));
            //expectedValues.add(B - A.get(i));
            evaluatedValues.add(A.get(i));
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> A = List.of(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98,
                69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29);

        System.out.println(diffPossible(A, 97)); //0
    }
}