package tests.facebook.interviewbits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateExpression {
    public static int evalRPN(ArrayList<String> A) {
        Map<String, BiFunction<Integer, Integer, Integer>> operations =  new HashMap<>();
        operations.put("+", Integer::sum);
        operations.put("-", (v1, v2) -> v1 - v2);
        operations.put("*", (v1, v2) -> v1 * v2);
        operations.put("/", (v1, v2) -> v1 / v2);
        int ans = 0;
        Stack<Integer> values = new Stack<>();
        for(String s : A) {
            if (operations.containsKey(s)) {
                int value2 = values.pop();
                int value1 = values.pop();
                ans = operations.get(s).apply(value1, value2);
                values.push(ans);
            } else {
                values.push(Integer.parseInt(s));
            }
        }
        return values.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new ArrayList<>(List.of("5", "1", "2", "+", "4", "*", "+", "3", "-"))));
    }
}

