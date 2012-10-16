package leetcode;

import util.BinarySearchTree;

/**
 * http://www.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-search -
 * tree.html
 * 
 * Questions to ask: 1. Whether it's a binary SEARCH tree 2. Could I use
 * recursion
 */
public class LCAOfBinarySearchTree {
    public BinarySearchTree.Node<Integer> solveRecursively(
            BinarySearchTree.Node<Integer> root,
            BinarySearchTree.Node<Integer> n1, BinarySearchTree.Node<Integer> n2) {
        return findLCA(root, n1, n2);
    }

    BinarySearchTree.Node<Integer> findLCA(BinarySearchTree.Node<Integer> root,
            BinarySearchTree.Node<Integer> n1, BinarySearchTree.Node<Integer> n2) {
        if (root == null || n1 == null || n2 == null) {
            throw new IllegalArgumentException();
        }

        BinarySearchTree.Node<Integer> current = root;

        if (current.key.compareTo(n1.key) < 0
                && current.key.compareTo(n2.key) < 0) {
            return findLCA(current.left, n1, n2);
        }

        if (current.key.compareTo(n1.key) > 0
                && current.key.compareTo(n2.key) > 0) {
            return findLCA(current.right, n1, n2);
        }

        return current;
    }

    public BinarySearchTree.Node<Integer> solveIteratively(
            BinarySearchTree.Node<Integer> root,
            BinarySearchTree.Node<Integer> n1, BinarySearchTree.Node<Integer> n2) {
        return findLCAIteratively(root, n1, n2);
    }

    BinarySearchTree.Node<Integer> findLCAIteratively(
            BinarySearchTree.Node<Integer> root,
            BinarySearchTree.Node<Integer> n1, BinarySearchTree.Node<Integer> n2) {
        if (root == null || n1 == null || n2 == null) {
            throw new IllegalArgumentException();
        }

        BinarySearchTree.Node<Integer> current = root;

        while ((current.key.compareTo(n1.key) < 0 && current.key
                .compareTo(n2.key) < 0)
                || (current.key.compareTo(n1.key) > 0 && current.key
                        .compareTo(n2.key) > 0)) {
            if (current.key.compareTo(n1.key) < 0
                    && current.key.compareTo(n2.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

}
