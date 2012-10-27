package leetcode;

/**
 * http://www.leetcode.com/2010/09/serializationdeserialization-of-binary.html
 */
public class SerializeBinaryTree {
    public String writeBinaryTree(Node root) {
        if (root == null) {
            return "[]";
        }

        String result = "[" + String.valueOf(root.value);
        result = result + "," + writeBinaryTree(root.left);
        result = result + "," + writeBinaryTree(root.right);
        result = result + "]";
        return result;
    }

    public Node readBinaryTree(String s) {
        return stringToBinaryTree(s.toCharArray(), 0, s.length() - 1);
    }

    private Node stringToBinaryTree(char[] s, int begin, int end) {
        if (begin >= end) {
            throw new IllegalArgumentException();
        }

        if (end - begin == 1) {
            return null;
        }

        assert (end - begin >= 8); // Not null, then minimum case is [1,[],[]]
        int valueLeft = begin + 1;
        int valueRight = valueLeft;
        while (s[valueRight] != ',' && valueRight < s.length) {
            valueRight++;
        }

        int value = charToValue(s, valueLeft, valueRight);
        Node root = new Node(value, null, null);
        int leftBracketOfLeftTree = valueRight + 1;
        assert s[leftBracketOfLeftTree] == '[';
        int rightBracketOfLeftTree = getMatchBracket(s, leftBracketOfLeftTree);
        int leftBracketOfRightTree = rightBracketOfLeftTree + 2;
        assert s[leftBracketOfRightTree] == '[';
        int rightBracketOfRightTree = getMatchBracket(s, leftBracketOfRightTree);

        root.left = stringToBinaryTree(s, leftBracketOfLeftTree,
                rightBracketOfLeftTree);
        root.right = stringToBinaryTree(s, leftBracketOfRightTree,
                rightBracketOfRightTree);

        return root;
    }

    private int getMatchBracket(char[] s, int left) {
        assert s[left] == '[';
        int bracketCount = 1;
        int current = left + 1;
        while (bracketCount > 0 && current < s.length) {
            if (s[current] == '[') {
                bracketCount++;
            }

            if (s[current] == ']') {
                bracketCount--;
            }

            current++;
        }
        assert s[current - 1] == ']';
        return current - 1;
    }

    private int charToValue(char[] s, int begin, int end) {
        assert begin <= end;
        assert end <= s.length;
        StringBuilder strBuilder = new StringBuilder();
        for (int i = begin; i < end; i++) {
            strBuilder.append(s[i]);
        }
        return Integer.parseInt(strBuilder.toString());
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
