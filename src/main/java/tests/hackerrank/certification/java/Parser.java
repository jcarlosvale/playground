package tests.hackerrank.certification.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parser {

    Deque<Character> stack;

    public boolean isBalanced(String someString) {
        stack = new ArrayDeque<>();
        if (someString.isEmpty()) return true;
        for (char c : someString.toCharArray()) {
            if (c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.pop();
                if (c == '}') {
                    if (top != '{') return false;
                } else {
                    if (top != '(') return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        System.out.println(parser.isBalanced("{}(){()}((())){{{}}}{()()}{{}{}}")); //true
    }
}
