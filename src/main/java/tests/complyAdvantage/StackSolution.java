package tests.complyAdvantage;

import java.util.*;

public class StackSolution {

    static final int MAX = 1048575; //2 ^ 20   - 1
    static final int MIN = 0;

    public static int isValidNumber(int number) throws Exception {
        if (!(number >= MIN && number <= MAX)) {
            throw new Exception();
        }
        return number;
    }

    public static int solution(String S) {
        try {
            Stack<Integer> stack = new Stack<>();
            String[] commands = S.split(" ");
            for (String command : commands) {
                execute(stack, command);
            }
            return stack.peek();
        } catch (Exception e) {
            return -1;
        }
    }

    private static void execute(Stack<Integer> stack, String command) throws Exception {
        command = command.trim();
        switch (command) {
            case "POP":
                stack.pop();
                break;
            case "DUP":
                stack.push(stack.peek());
                break;
            case "+":
                int value1 = stack.pop();
                int value2 = stack.pop();
                stack.push(isValidNumber(value1+value2));
                break;
            case "-":
                value1 = stack.pop();
                value2 = stack.pop();
                stack.push(isValidNumber(value1-value2));
                break;
            default:
                int value = Integer.parseInt(command);
                stack.push(isValidNumber(value));
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -"));
    }
}
