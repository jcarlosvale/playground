package tests.datastructures;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BinarySearchTree {
    private int val;
    private BinarySearchTree left;
    private BinarySearchTree right;
    private BinarySearchTree parent;

    public BinarySearchTree search(BinarySearchTree node, int val) {
        if (node != null) {
            if (node.val == val) return node;
            if (val < node.val) {
                return search(node.left, val);
            } else {
                return search(node.right, val);
            }
        }
        return null;
    }

}
