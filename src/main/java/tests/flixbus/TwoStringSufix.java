package tests.flixbus;

public class TwoStringSufix {

    public static boolean match(String input, String example) {
        int index1 = 0;
        int index2 = 0;

        while(index1 < input.length() && index2 < example.length()) {
            char c = input.charAt(index1);
            char e = example.charAt(index2);
            if (c >= '0' && c <= '9') {
                int n = c - '0';
                index2 += n;
                index1++;
            } else {
                if (c != e) return false;
                index1++;
                index2++;
            }
        }
        return (index1 == input.length() && index2 == example.length());
    }

    public static void main(String[] args) {
        System.out.println(match("f3bus", "flixbus")); //true
        System.out.println(match("f3bus", "flix")); //false

        System.out.println(match("f3bus", "flixbuses")); //false

        System.out.println(match("f0bus", "fbus")); //true

    }
}
