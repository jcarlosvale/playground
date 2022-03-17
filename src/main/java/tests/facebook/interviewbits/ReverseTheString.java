package tests.facebook.interviewbits;

public class ReverseTheString {
    public static String solve(String A) {
        String [] strings = A.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strings.length - 1; i >= 0; i--) {
            String str = strings[i].trim();
            if (!str.isEmpty()) {
                sb.append(str).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
