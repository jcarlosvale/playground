package tests.leetcode.challenge30days;

import tests.leetcode.challenge30days.dataStructure.ListNode;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */

public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        if (head.next == null) return head;
        ListNode copy = head;
        while(copy != null){
            count++;
            copy = copy.next;
        }

        count = count /2 + 1;
        copy = head;
        for(int i = 2; i <= count; i++) {
            copy = copy.next;
        }
        return copy;
    }

    public static int middleNode(int [] head) {
        int count = 0;
        if (head.length == 1) return head[0];
        int  copy = 0;
        while(copy != head.length){
            count++;
            copy++;
        }
        if (count % 2 == 0){
            count = count/2 + 1;
        }
        else {
            count = count/2 + 1;
        }

        System.out.println(count);

        copy = 0;
        for(int i = 2; i <= count; i++) {
            copy++;
        }
        return head[copy];
    }

    public static void main(String[] args) {
        System.out.println(middleNode(new int [] {1,2,3,4,5}));
    }
}
