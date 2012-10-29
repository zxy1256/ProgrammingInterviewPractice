package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintBinaryTreeLevelOrderUsingDFS {
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

    public void print(Node root) {
        List<List<Node>> nodesByLevel = new ArrayList<List<Node>>();
        populate(root, 0, nodesByLevel);
        for (List<Node> nodes : nodesByLevel) {
            for (Node n : nodes) {
                System.out.print(n.value + " ");
            }
            System.out.print("\n");
        }
    }

    private void populate(Node root, int level, List<List<Node>> nodesByLevel) {
        if (root == null) {
            return;
        }

        if (level >= nodesByLevel.size()) {
            nodesByLevel.add(new LinkedList<Node>());
        }

        List<Node> nodes = nodesByLevel.get(level);
        nodes.add(root);
        populate(root.left, level + 1, nodesByLevel);
        populate(root.right, level + 1, nodesByLevel);
    }
}
