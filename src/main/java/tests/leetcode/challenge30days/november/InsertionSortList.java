package tests.leetcode.challenge30days.november;

import tests.leetcode.challenge30days.dataStructure.ListNode;

/*
Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode sortedList = new ListNode(head.val);
        head = head.next;
        while(head != null) {
            insert(sortedList, head.val);
            head = head.next;
        }
        return sortedList;
    }

    private static void insert(ListNode sortedList, int val) {
        ListNode currentNode = sortedList;
        ListNode nextNode = sortedList.next;
        boolean inserted = false;
        while(!inserted) {
            if(val <= currentNode.val) {
                int temp = currentNode.val;
                currentNode.val = val;
                ListNode newNode = new ListNode(temp);
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                inserted = true;
            } else {
                if (nextNode == null || val <= nextNode.val) {
                    ListNode newNode = new ListNode(val);
                    newNode.next = nextNode;
                    currentNode.next = newNode;
                    inserted = true;
                } else {
                    currentNode = nextNode;
                    nextNode = currentNode.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode list =
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(1,
                                        new ListNode(3, null))));
        System.out.println(insertionSortList(list));

    }
}
