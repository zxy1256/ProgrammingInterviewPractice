package leetcode;

import leetcode.SaveBinarySearchTreeToFile.Node;

import org.junit.Test;

public class SaveBinarySearchTreeToFileTest {
    @Test
    public void testBalancedTree() {
        SaveBinarySearchTreeToFile problem = new SaveBinarySearchTreeToFile();
        Node n10 = new Node(10, null, null);
        Node n20 = new Node(20, n10, null);
        Node n35 = new Node(35, null, null);
        Node n50 = new Node(50, null, null);
        Node n40 = new Node(40, n35, n50);
        Node n30 = new Node(30, n20, n40);
        test(problem, n30);
    }

    @Test
    public void testLeftOnlyTree() {
        SaveBinarySearchTreeToFile problem = new SaveBinarySearchTreeToFile();
        Node n10 = new Node(10, null, null);
        Node n20 = new Node(20, n10, null);
        Node n35 = new Node(35, n20, null);
        Node n50 = new Node(50, n35, null);
        test(problem, n50);
    }

    private void test(SaveBinarySearchTreeToFile problem, Node n30) {
        String s = problem.binarySearchTreeToString(n30);
        System.out.println(s);
        Node t = problem.stringToBST(s);
        System.out.println(problem.binarySearchTreeToString(t));
    }
}
