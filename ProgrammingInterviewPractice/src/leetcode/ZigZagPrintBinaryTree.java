package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * http://www.leetcode.com/2010/09/printing-binary-tree-in-zig-zag-level_18.html
 * 
 * Mistake I made:
 * <ol>
 * <li>Iterator --> Iterator<Node></li>
 * <li>Variable name wrong</li>
 * </ol>
 * 
 */
public class ZigZagPrintBinaryTree {
    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void printZigZag(Node root) {
        Deque<Node> q = new ArrayDeque<Node>();
        Deque<Node> printDeque = new ArrayDeque<Node>();
        boolean leftToRight = true;
        int currentLevelCount = 0;
        int nextLevelCount = 0;

        q.add(root);
        currentLevelCount++;
        while (!q.isEmpty()) {
            Node n = q.poll();
            currentLevelCount--;
            if (n.left != null) {
                q.add(n.left);
                nextLevelCount++;
            }

            if (n.right != null) {
                q.add(n.right);
                nextLevelCount++;
            }

            if (leftToRight) {
                printDeque.addLast(n);
            } else {
                printDeque.addFirst(n);
            }

            if (currentLevelCount == 0) {
                printOneLevel(printDeque);
                leftToRight = !leftToRight;
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

    private void printOneLevel(Deque<Node> printDeque) {
        Iterator<Node> it = printDeque.iterator();
        System.out.print(it.next().value);
        while (it.hasNext()) {
            System.out.print(" " + it.next().value);
        }
        System.out.print("\n");
        printDeque.clear();
    }
}
