package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class IsBSTTest {
    @Test
    public void testPositive() {
        IsBST problem = new IsBST();
        Node n10 = new Node(10, null, null);
        Node n20 = new Node(20, n10, null);
        Node n35 = new Node(35, null, null);
        Node n50 = new Node(50, null, null);
        Node n40 = new Node(40, n35, n50);
        Node n30 = new Node(30, n20, n40);
        Assert.assertTrue(problem.isBST(n30));
    }

    @Test
    public void testNegative() {
        IsBST problem = new IsBST();
        Node n6 = new Node(6, null, null);
        Node n20 = new Node(20, null, null);
        Node n15 = new Node(15, n6, n20);
        Node n5 = new Node(5, null, null);
        Node n10 = new Node(10, n5, n15);
        Assert.assertFalse(problem.isBST(n10));
    }
}
