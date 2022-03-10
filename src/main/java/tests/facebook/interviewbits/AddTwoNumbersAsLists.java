package tests.facebook.interviewbits;

import tests.leetcode.challenge30days.dataStructure.ListNode;

public class AddTwoNumbersAsLists {
    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        boolean endOfA = false;
        boolean endOfB = false;
        ListNode ans = null;
        ListNode previousPosition  = null;
        int acc = 0;
        int sum = 0;
        while(!endOfA || !endOfB) {
            sum = acc;
            if (!endOfA) {
                sum += A.val;
                A = A.next;
                endOfA = A == null;
            }
            if (!endOfB) {
                sum += B.val;
                B = B.next;
                endOfB = B == null;
            }
            acc = sum / 10;
            sum = sum % 10;

            if(ans == null) {
                ans = new ListNode(sum);
                previousPosition = ans;
            } else {
                previousPosition.next = new ListNode(sum);
                previousPosition = previousPosition.next;
            }
        }
        if (acc > 0) {
            previousPosition.next = new ListNode(acc);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode A =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(3)));
        ListNode B =
                new ListNode(5,
                        new ListNode(6,
                                new ListNode(4)));

        System.out.println(addTwoNumbers(A, B)); //708

        A =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(1)));
        B =
                new ListNode(1);
        System.out.println(addTwoNumbers(A, B)); //002

        A =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9)));
        B =
                new ListNode(1);
        System.out.println(addTwoNumbers(A, B)); //0001

    }
}
