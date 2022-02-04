package tests.bauhaus;

import java.util.LinkedList;

public class StackOperations {

    public int solution(String S) {
        final double MAX_VALUE = Math.pow(2,20) - 1;
        final int MIN_VALUE = 0;
        final LinkedList<Integer> stack = new LinkedList<>();

        for(String word: S.split(" ")) {
            if (word.equals("+")) {
                if (stack.size() >= 2) {
                    int result = stack.pop() + stack.pop();
                    if (result < MIN_VALUE || result > MAX_VALUE) {
                        return -1;
                    } else {
                        stack.push(result);
                    }
                } else {
                    return -1;
                }
            } else {
                if (word.equals("-")) {
                    if (stack.size() >= 2) {
                        int result = stack.pop() - stack.pop();
                        if (result < MIN_VALUE || result > MAX_VALUE) {
                            return -1;
                        } else {
                            stack.push(result);
                        }
                    } else {
                        return -1;
                    }
                } else {
                    if (word.equals("DUP")) {
                        if (!stack.isEmpty()) {
                            stack.push(stack.getFirst());
                        } else {
                            return -1;
                        }
                    } else {
                        if (word.equals("POP")) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            } else {
                                return -1;
                            }
                        } else {
                            stack.push(Integer.parseInt(word));
                        }
                    }
                }
            }
        }

        if(stack.isEmpty()) return -1;
        return stack.pop();
    }
}
