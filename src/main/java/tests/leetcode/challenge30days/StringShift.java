package tests.leetcode.challenge30days;

public class StringShift {
    public static String stringShift(String s, int[][] shift) {
        char [] string = new char[s.length()];
        int totalAmount = 0;
        for (int i = 0; i < s.length(); i++) {
            string[i] = s.charAt(i);
        }
        for(int [] operation : shift) {
            if (operation[0] == 0) {
                totalAmount -= operation[1];
            } else {
                totalAmount += operation[1];
            }
        }
        totalAmount = totalAmount% s.length();
        if (totalAmount < 0) {
            int newIndex;
            for(int i = 0; i < s.length(); i++) {
                newIndex = i + totalAmount;
                if (newIndex < 0) {
                    newIndex = (s.length() + newIndex);
                }
                string[newIndex] = s.charAt(i);
            }
        }
        if (totalAmount > 0) {
            int newIndex;
            for(int i = 0; i < s.length(); i++) {
                newIndex = (i + totalAmount) % string.length;
                string[newIndex] = s.charAt(i);
            }
        }
        return new String(string);
    }

    public static void main(String[] args) {
        System.out.println(stringShift("abc", new int[][]{{0,1},{1,2}}));
  //      System.out.println(stringShift("abcdefg", new int[][]{{1,1},{1,1},{0,2},{1,3}}));
//        System.out.println(stringShift("wpdhhcj", new int[][]{{0,7},{1,7},{1,0},{1,3},{0,3},{0,6},{1,2}}));
        System.out.println(stringShift("xqgwkiqpif", new int[][]{{1,4},{0,7},{0,8},{0,7},{0,6},{1,3},{0,1},{1,7},{0,5},{0,6}}));
    }
}
