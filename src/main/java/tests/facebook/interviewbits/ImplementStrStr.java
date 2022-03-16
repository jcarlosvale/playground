package tests.facebook.interviewbits;

public class ImplementStrStr {

    public static  int strStr(final String A, final String B) {
        if (A == null || B == null || B.length() > A.length()) return -1;
        int size = B.length();
        int i = 0;
        while(i <= A.length() - size) {
            if (compare(A, B, i, i+size-1)) return i;
            i++;
        }
        return -1;
    }

    private static boolean compare(String A, String B, int start, int end) {
        for(int i = start; i <= end; i++) {
            if (A.charAt(i) != B.charAt(i - start)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(strStr("123casa", "casa"));
        System.out.println(strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa")); //48
    }
}
