package tests.crackCode.lista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    int data;
    BinarySearchTree leftNode;
    BinarySearchTree rightNode;

    public BinarySearchTree(int data) {
        this.data = data;
    }

    public void insert(int data) {
        insert(this, data);
    }

    private void insert(BinarySearchTree binarySearchTree, int data) {
        if (data > binarySearchTree.data) {
            if (null == binarySearchTree.rightNode) {
                binarySearchTree.rightNode = new BinarySearchTree(data);
            } else {
                insert(binarySearchTree.rightNode, data);
            }
        } else {
            if (null == binarySearchTree.leftNode) {
                binarySearchTree.leftNode = new BinarySearchTree(data);
            } else {
                insert(binarySearchTree.leftNode, data);
            }
        }
    }

    public Integer[] bfs() {
        List<Integer> result = new ArrayList<>();
        LinkedList<BinarySearchTree> list = new LinkedList<>();
        list.add(this);
        while(!list.isEmpty()) {
            BinarySearchTree element = list.pollFirst();
            result.add(element.data);
            if(element.leftNode != null) {
                list.add(element.leftNode);
            }
            if(element.rightNode != null) {
                list.add(element.rightNode);
            }
        }
        return result.toArray(new Integer[0]);
    }

    public Integer[] inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(this, result);
        return result.toArray(new Integer[0]);
    }

    private void inOrder(BinarySearchTree binarySearchTree, List<Integer> result) {
        if (binarySearchTree == null) return;
        inOrder(binarySearchTree.leftNode, result);
        result.add(binarySearchTree.data);
        inOrder(binarySearchTree.rightNode, result);
    }

    public Integer[] preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrder(this, result);
        return result.toArray(new Integer[0]);
    }

    private void preOrder(BinarySearchTree binarySearchTree, List<Integer> result) {
        if (binarySearchTree == null) return;
        result.add(binarySearchTree.data);
        preOrder(binarySearchTree.leftNode, result);
        preOrder(binarySearchTree.rightNode, result);
    }

    public Integer[] posOrder() {
        List<Integer> result = new ArrayList<>();
        posOrder(this, result);
        return result.toArray(new Integer[0]);
    }

    private void posOrder(BinarySearchTree binarySearchTree, List<Integer> result) {
        if (binarySearchTree == null) return;
        posOrder(binarySearchTree.leftNode, result);
        posOrder(binarySearchTree.rightNode, result);
        result.add(binarySearchTree.data);
    }
}
