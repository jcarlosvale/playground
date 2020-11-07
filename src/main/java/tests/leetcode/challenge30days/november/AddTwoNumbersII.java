package tests.leetcode.challenge30days.november;

import tests.leetcode.challenge30days.dataStructure.ListNode;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3522/
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = listToStack(l1);
        Stack<Integer> stack2 = listToStack(l2);
        return sum(stack1, stack2);
    }

    private static ListNode sum(Stack<Integer> stack1, Stack<Integer> stack2) {
        ListNode listSum = null;
        int n1, n2, sum, carry = 0;
        while(!(stack1.isEmpty() && stack2.isEmpty())) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = n1 + n2 + carry;
            carry = sum / 10;
            listSum = new ListNode(sum % 10, listSum);
        }
        //carry
        if (carry > 0) listSum = new ListNode(carry, listSum);
        return listSum;
    }

    private static Stack listToStack(ListNode l1) {
        ListNode current = l1;
        Stack<Integer> stack = new Stack();
        while(current != null) {
            stack.push(current.val);
            current = current.next;
        }
        return stack;
    }
}
