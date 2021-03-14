package tests.leetcode.challenge30days.march2021;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3671/
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
from the end (the list is 1-indexed).



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
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
public class Swapping_Nodes_In_A_Linked_List {
    public static ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        int pos1 = k-1; //previous position
        int pos2 = count - k; //previous position
        ListNode node1 = head;
        ListNode node2 = head;
        while ((pos1 > 0) || (pos2  > 0)){
            if (pos1 > 0) {
                node1 = node1.next;
            }
            if (pos2 > 0) {
                node2 = node2.next;
            }
            pos1--;
            pos2--;
        }
        //swap
        if (node1 != node2) {
            int temp = node2.val;
            node2.val = node1.val;
            node1.val = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        swapNodes(listNode, 2);
        System.out.println(listNode.toString());
    }
}
