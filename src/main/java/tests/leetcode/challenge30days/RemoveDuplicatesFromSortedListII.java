package tests.leetcode.challenge30days;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import tests.leetcode.challenge30days.dataStructure.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> storedElements = new HashSet<>();
        Stack<Integer> elements = new Stack<>();

        while(head != null) {
            if (storedElements.contains(head.val)) {
                if (!elements.empty() && elements.peek() == head.val) {
                    elements.pop();
                }
            } else {
                storedElements.add(head.val);
                elements.push(head.val);
            }
            head = head.next;
        }

        ListNode ans = null;
        ListNode temp = null;
        while(!elements.empty()) {
            if (ans == null) {
                ans = new ListNode(elements.pop(), null);
            } else {
                temp = new ListNode(elements.pop(), ans);
                ans = temp;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4,
                                                                new ListNode(5)))))));

        System.out.println(deleteDuplicates(listNode));

        listNode =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3)))));

        System.out.println(deleteDuplicates(listNode));
    }
}
