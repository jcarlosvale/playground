package tests.klarna;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

import static java.lang.Character.isDigit;

class CreditCard {
    private final static char REPLACE = '#';

    public static String maskify(String creditCardNumber) {
        if (creditCardNumber == null || creditCardNumber.length() < 6) return creditCardNumber;

        char [] charArray = creditCardNumber.toCharArray();
        for (int i = 1; i < charArray.length - 4; i++) {
            if(isDigit(charArray[i])) {
                charArray[i] = REPLACE;
            }
        }
        Map<String, BiFunction<Double, Double, Double>> map = new HashMap<>();
        map.put("+", (op1, op2) -> op1 + op2);
        map.put("-", Double::);
        map.put("+", Double::sum);
        map.put("*", Double::sum);
        map.get("s").apply(1.0, 2.0);
        map.

        Stack<Character> stack = new Stack<>();


        return new String(charArray);
    }

}