package leetcode;

import leetcode.PrintBinaryTreeLevelOrderUsingDFS.Node;

import org.junit.Test;

public class PrintBinaryTreeLevelOrderUsingDFSTest {
    @Test
    public void test() {
        PrintBinaryTreeLevelOrderUsingDFS problem = new PrintBinaryTreeLevelOrderUsingDFS();
        Node n10 = new Node(10, null, null);
        Node n20 = new Node(20, n10, null);
        Node n35 = new Node(35, null, null);
        Node n50 = new Node(50, null, null);
        Node n40 = new Node(40, n35, n50);
        Node n30 = new Node(30, n20, n40);
        problem.print(n30);
    }
}
