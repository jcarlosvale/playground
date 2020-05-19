package tests.leetcode.challenge30days.may;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
 * talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */


import tests.leetcode.challenge30days.dataStructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        ListNode reader = head;

        ListNode even = null;
        ListNode lastNode = null;

        while (reader != null) {
            if (even == null) {
                even = reader.next;
                lastNode = even;
            } else {
                lastNode.next = reader.next;
                lastNode = lastNode.next;
            }
            if (reader.next != null) {
                reader.next = reader.next.next;
                if (reader.next == null) {
                    reader.next = even;
                    reader = null;
                }
            } else {
                reader.next = even;
                reader = null;
            }
            if (reader != null) reader = reader.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,
                                                                new ListNode(7,
                                                                        new ListNode(8, null))))))));
        list = oddEvenList(list);
        System.out.println(list);

    }
}
