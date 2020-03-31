package tests.crackCode.lista;

import java.util.*;

public class Node {
    Node next;
    int data;
    public Node(int data) {
        this.data = data;
    }
    public void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNode(Node head, int data) {
        Node n = head;
        if (n.data == data) {
            return head.next;
        }
        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node raiz = new Node(1);
        raiz.appendToTail(2);
        raiz.appendToTail(3);
        System.out.println(raiz);
        raiz = raiz.deleteNode(raiz,2);
        System.out.println(raiz);

        String x = " ";
        System.out.println(x.length());

        int [] arr = { 1,2,3};
        System.out.println(arr.length);

        List<Integer> y = new ArrayList<>();
        System.out.println(y.size());

        Set<Integer> set = new HashSet<>();
        System.out.println(set.size());
    }

}
