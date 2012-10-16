package leetcode;

import util.BinarySearchTree;

/**
 * http://www.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-
 * i.html
 * 
 * Here is a good tutorial of the LCA problem:
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=
 * lowestCommonAncestor
 * 
 * @author sean
 * 
 */
public class LCAOfBinaryTree {
    public BinarySearchTree.Node<Integer> solve(
            BinarySearchTree.Node<Integer> root,
            BinarySearchTree.Node<Integer> n1, BinarySearchTree.Node<Integer> n2) {
        return LCA(root, n1, n2);
    }

    BinarySearchTree.Node<Integer> LCA(BinarySearchTree.Node<Integer> root,
            BinarySearchTree.Node<Integer> n1, BinarySearchTree.Node<Integer> n2) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            return null;
        }
        if (root == n1 || root == n2) {
            return root;
        }

        BinarySearchTree.Node<Integer> left = LCA(root.left, n1, n2);
        BinarySearchTree.Node<Integer> right = LCA(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
