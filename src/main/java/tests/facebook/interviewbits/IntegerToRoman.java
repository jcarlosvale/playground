package tests.facebook.interviewbits;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int A) {
        Map<Integer, String> romanMap = loadRomanMap();
        StringBuilder ans = new StringBuilder();

        int thousand = A / 1000;
        if (thousand > 0) {
            ans.append(romanMap.get(thousand * 1000));
        }

        A = A % 1000;
        int hundred = A / 100;
        if (hundred > 0) {
            ans.append(romanMap.get(hundred * 100));
        }

        A = A % 100;
        int  dozens = A / 10;
        if (dozens > 0) {
            ans.append(romanMap.get(dozens * 10));
        }

        A = A % 10;
        if (A > 0) {
            ans.append(romanMap.get(A));
        }

        return ans.toString();
    }

    private static Map<Integer, String> loadRomanMap() {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(2, "II");
        romanMap.put(3, "III");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(6, "VI");
        romanMap.put(7, "VII");
        romanMap.put(8, "VIII");
        romanMap.put(9, "IX");

        romanMap.put(10, "X");
        romanMap.put(20, "XX");
        romanMap.put(30, "XXX");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(60, "LX");
        romanMap.put(70, "LXX");
        romanMap.put(80, "LXXX");
        romanMap.put(90, "XC");

        romanMap.put(100, "C");
        romanMap.put(200, "CC");
        romanMap.put(300, "CCC");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(600, "DC");
        romanMap.put(700, "DCC");
        romanMap.put(800, "DCCC");
        romanMap.put(900, "CM");

        romanMap.put(1000, "M");
        romanMap.put(2000, "MM");
        romanMap.put(3000, "MMM");

        return romanMap;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1918 ));
    }
}
