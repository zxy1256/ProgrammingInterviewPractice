package leetcode;

import leetcode.ZigZagPrintBinaryTree.Node;

import org.junit.Test;

public class ZigZagPrintBinaryTreeTest {
    @Test
    public void test() {
        ZigZagPrintBinaryTree problem = new ZigZagPrintBinaryTree();
        Node n10 = new Node(10, null, null);
        Node n20 = new Node(20, n10, null);
        Node n35 = new Node(35, null, null);
        Node n50 = new Node(50, null, null);
        Node n40 = new Node(40, n35, n50);
        Node n30 = new Node(30, n20, n40);
        problem.printZigZag(n30);
    }
}
