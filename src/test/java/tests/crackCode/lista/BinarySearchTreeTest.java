package tests.crackCode.lista;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BinarySearchTreeTest {

    @Test
    public void testBFS() {
        BinarySearchTree tree = createBinarySearchTree();
        Integer [] actual = tree.bfs();
        Integer [] expected = {4,2,6,1,3,5,7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInOrder() {
        BinarySearchTree tree = createBinarySearchTree();
        Integer [] actual = tree.inOrder();
        Integer [] expected = {1,2,3,4,5,6,7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPreOrder() {
        BinarySearchTree tree = createBinarySearchTree();
        Integer [] actual = tree.preOrder();
        Integer [] expected = {4,2,1,3,6,5,7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPosOrder() {
        BinarySearchTree tree = createBinarySearchTree();
        Integer [] actual = tree.posOrder();
        Integer [] expected = {1,3,2,5,7,6,4};
        assertArrayEquals(expected, actual);
    }

    private BinarySearchTree createBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        return tree;
    }

}
