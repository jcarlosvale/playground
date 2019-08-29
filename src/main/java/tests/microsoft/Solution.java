package tests.microsoft;

import java.util.Arrays;

public class Solution {
    public static int solution(int N) {
        boolean isNegative = N < 0;
        N = Math.abs(N);
        String strNum = Integer.toString(N);
        int [] possibilities = new int[strNum.length()+1];
        possibilities[0] = Integer.parseInt(5+strNum);
        for(int i = 0; i<strNum.length(); i++) {
            possibilities[i+1] = Integer.parseInt(strNum.substring(0,i+1) + "5" + strNum.substring(i+1));
        }
        if (isNegative) {
            for (int i=0; i<possibilities.length; i++) {
                possibilities[i] = -possibilities[i];
            }
        }
        Arrays.sort(possibilities);
        return possibilities[possibilities.length-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(268));
        System.out.println(solution(670));
        System.out.println(solution(0));
        System.out.println(solution(-999));
        System.out.println("*********************");
        for(int i=-8000; i<= 8000; i++) {
            System.out.println(i + " <<<< " + solution(i));
        }
    }
}
