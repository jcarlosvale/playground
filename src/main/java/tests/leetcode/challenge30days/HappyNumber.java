package tests.leetcode.challenge30days;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }

    private static boolean isHappy(int n, Set<Integer> set) {
        if (set.contains(n)) return false;
        else {
            set.add(n);
            String strNumber = String.valueOf(n);
            int sum = 0;
            for(int i = 0; i < strNumber.length(); i++) {
                int digit = Integer.parseInt(strNumber.substring(i,i+1));
                sum += (digit * digit);
            }
            if (sum == 1) return true;
            return isHappy(sum, set);
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
