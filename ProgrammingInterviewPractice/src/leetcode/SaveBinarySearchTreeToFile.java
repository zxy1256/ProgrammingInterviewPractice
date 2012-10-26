package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.leetcode.com/2010/09/saving-binary-search-tree-to-file.html
 * 
 * Tag: recursive, Binary Search Tree
 */
public class SaveBinarySearchTreeToFile {
    public String binarySearchTreeToString(Node root) {
        if (root == null) {
            return "";
        }

        String leftTree = binarySearchTreeToString(root.left);
        String rightTree = binarySearchTreeToString(root.right);
        String result = String.valueOf(root.value);
        if (!leftTree.isEmpty()) {
            result = result + "," + leftTree;
        }
        if (!rightTree.isEmpty()) {
            result = result + "," + rightTree;
        }
        return result;
    }

    public Node stringToBST(String s) {
        String[] nodeValueStrings = s.split(",");
        List<Integer> nodeValues = new ArrayList<Integer>();
        for (String v : nodeValueStrings) {
            nodeValues.add(Integer.parseInt(v));
        }
        return restoreFromPreorderTraversal(nodeValues);
    }

    private Node restoreFromPreorderTraversal(List<Integer> nodeValues) {
        if (nodeValues == null || nodeValues.isEmpty()) {
            return null;
        }

        Node root = new Node(nodeValues.get(0), null, null);
        int i = 1;
        for (i = 1; i < nodeValues.size() && nodeValues.get(i) <= root.value; i++) {
        }

        if (nodeValues.size() > 1) {
            root.left = restoreFromPreorderTraversal(nodeValues.subList(1, i));
        }

        if (i < nodeValues.size()) {
            root.right = restoreFromPreorderTraversal(nodeValues.subList(i,
                    nodeValues.size()));
        }
        return root;
    }

    public static class Node {
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node left;
        Node right;
        int value;
    }
}
