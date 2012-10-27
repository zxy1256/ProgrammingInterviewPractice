package leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * http://www.leetcode.com/2010/09/serializationdeserialization-of-binary.html
 */
public class SerializeBinaryTree {
    public String writeBinaryTree(Node root) {
        if (root == null) {
            return "#";
        }

        String result = String.valueOf(root.value);
        result = result + "," + writeBinaryTree(root.left);
        result = result + "," + writeBinaryTree(root.right);
        return result;
    }

    public Node readBinaryTree(String s) {
        List<String> tokens = Arrays.asList(s.split(","));
        Iterator<String> itr = tokens.iterator();
        return readBinaryTree(itr);
    }

    private Node readBinaryTree(Iterator<String> itr) {
        if (!itr.hasNext()) {
            return null;
        }

        String token = itr.next();
        if (token.equals("#")) {
            return null;
        }

        int value = Integer.parseInt(token);
        Node root = new Node(value, null, null);
        root.left = readBinaryTree(itr);
        root.right = readBinaryTree(itr);

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
