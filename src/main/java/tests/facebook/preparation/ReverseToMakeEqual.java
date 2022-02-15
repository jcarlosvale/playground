package tests.facebook.preparation;

import java.util.Stack;

public class ReverseToMakeEqual {

    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length) return false;

        final Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;
        while(i < array_a.length) {
            while(j < array_b.length && array_a[i] != array_b[j]) {
                stack.push(array_b[j]);
                j++;
            }
            if (j >= array_b.length) {
                return false;
            } else {
                i++;
                j++;
                while(!stack.empty()) {
                    if (array_a[i] != stack.pop())
                        return false;
                    i++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,2}));  //true
    }
}
