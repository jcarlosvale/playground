package tests.facebook.interviewbits;

public class MinimumAppendForPalindrome {

    public static int solve(String A) {
        int ans = 0;
        int start = 0;
        int end = A.length()-1;
        while(start < end){
            if (A.charAt(start) == A.charAt(end)) {
                start++;
                end--;
            }
        }

        return ans;
    }

}
