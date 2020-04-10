package tests.leetcode.challenge30days;

public class MinStack {

    Node head;

    private class Node {
        int value;
        int min;
        Node next;
    }


    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node();
            head.min = x;
            head.value = x;
        } else {
            Node node = new Node();
            node.value = x;
            int min = head.min;
            if (x < min) {
                min = x;
            }
            node.min = min;
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

