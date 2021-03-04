package tests.leetcode.challenge30days.march2021;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3660/
Write a program to find the node at which the intersection of two singly linked lists begins.
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.
 */

import tests.leetcode.challenge30days.dataStructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeListA = 0;
        int sizeListB = 0;

        ListNode navigateA = headA;
        ListNode navigateB = headB;
        //count
        while(navigateA != null || navigateB != null) {
            if (navigateA != null) {
                sizeListA++;
                navigateA = navigateA.next;
            }
            if (navigateB != null) {
                sizeListB++;
                navigateB = navigateB.next;
            }
        }

        //diff
        int dif = Math.abs(sizeListA - sizeListB);
        navigateA = headA;
        navigateB = headB;
        if (sizeListA > sizeListB) {
            while(dif > 0) {
                navigateA = navigateA.next;
                dif--;
            }
        } else {
            while(dif > 0) {
                navigateB = navigateB.next;
                dif--;
            }
        }

        //intersection
        while(navigateA != null && navigateB != null) {
            if(navigateA.equals(navigateB)) {
                return navigateA;
            }
            navigateA = navigateA.next;
            navigateB = navigateB.next;
        }
        return null;
    }
}
