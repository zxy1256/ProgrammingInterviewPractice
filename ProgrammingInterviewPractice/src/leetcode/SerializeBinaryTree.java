package leetcode;

/**
 * http://www.leetcode.com/2010/09/serializationdeserialization-of-binary.html
 */
public class SerializeBinaryTree {
    public String binaryTreeToString(Node root) {
        if (root == null) {
            return "";
        }
        
        String result = String.valueOf(root.value);
        result = result + ", [ " + binaryTreeToString(root.left) + " ] ";
        result = result + ", [ " + binaryTreeToString(root.right) + " ] ";
        return result;
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
