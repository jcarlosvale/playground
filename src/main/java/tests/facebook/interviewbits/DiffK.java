package tests.facebook.interviewbits;

import java.util.ArrayList;

public class DiffK {
    //SORTED A
    public static int diffPossible(ArrayList<Integer> A, int B) {
        if (A.size() < 2) return 0;
        int start = 0;
        int end = 1;
        while(start < A.size() && end < A.size()) {
            int diff = A.get(end) - A.get(start);
            if ((start != end) && (diff == B || diff == -B)) return 1;
            if (diff > B) {
                start++;
            } else {
                end++;
            }
        }
        return 0;
    }
}