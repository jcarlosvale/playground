package tests.amazon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}



class Result {

    /*
     * Complete the 'maximumPages' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static int maximumPages(SinglyLinkedListNode head) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        SinglyLinkedListNode copy = head;
        while(copy.next != null) {
            count++;
            copy = copy.next;
        }

        SinglyLinkedListNode middle = head;
        for (int i = 1; i <= count / 2 ; i++) {
            middle = middle.next;
        }
        //stack middle
        while(middle != null) {
            stack.push(middle.data);
            middle = middle.next;
        }

        int ans = 0;
        copy = head;
        while(!stack.isEmpty()) {
            ans = Math.max(ans, copy.data + stack.pop());
            copy = copy.next;
        }

        return ans;
    }

}