package leetcode;

public class IsBST {
    public boolean isBST(Node root) {
        return check(root, Integer.MIN_VALUE);
    }

    private boolean check(Node root, int previousValue) {
        if (root == null) {
            return true;
        }

        return check(root.left, previousValue) && (root.value > previousValue)
                && check(root.right, root.value);
    }
}
