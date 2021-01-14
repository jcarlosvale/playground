package tests.zalando;

public class Q1 {
    public static int solution(String s) {
        int max = Integer.MIN_VALUE;
        int c1 = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            int c2 = s.charAt(i) - '0';
            int number = c1 * 10 + c2;
            if (number > max) {
                max = number;
            }
            c1 = c2;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution("50552"));
        System.out.println(solution("10101"));
        System.out.println(solution("88"));
    }
}
