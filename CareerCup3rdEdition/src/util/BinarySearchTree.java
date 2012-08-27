package util;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Unbalanced binary search tree.
 * 
 * @author sean
 * 
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements
        BFSIterable<T>, DFSIterable<T>, Iterable<T> {
    private Node<T> root;
    private int size;

    public static class Node<E> {
        Node<E> parent;
        Node<E> left;
        Node<E> right;
        E key;

        public Node(Node<E> parent, E key) {
            this.parent = parent;
            this.key = key;
        }
    }

    /**
     * Return true if the key does not exist and insert success. Return false
     * otherwise.
     */
    public boolean insert(T key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (root == null) {
            root = new Node<T>(null, key);
            size = 1;
            return true;
        }

        Node<T> p = null; // Parent node
        Node<T> c = root; // Current node
        while (c != null) {
            if (key.compareTo(c.key) < 0) {
                p = c;
                c = c.left;
            } else if (key.compareTo(c.key) > 0) {
                p = c;
                c = c.right;
            } else {
                return false;
            }
        }

        if (key.compareTo(p.key) < 0) {
            p.left = new Node<T>(p, key);
        } else {
            p.right = new Node<T>(p, key);
        }
        size++;
        return true;
    }

    public boolean delete(Node<T> n) {
        size--;

        Node<T> y = (n.left == null || n.right == null) ? n : successor(n);
        Node<T> x = y.left == null ? y.right : y.left;
        if (x != null) {
            x.parent = y.parent;
        }
        if (y.parent == null) {
            root = x;
        } else {
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        if (y != n) {
            n.key = y.key;
        }
        return false;
    }

    public boolean contains(T key) {
        if (root == null) {
            return false;
        }

        Node<T> c = root;
        while (c != null) {
            if (key.compareTo(c.key) < 0) {
                c = c.left;
            } else if (key.compareTo(c.key) > 0) {
                c = c.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public Node<T> getNode(T key) {
        if (root == null) {
            return null;
        }

        Node<T> c = root;
        while (c != null) {
            if (key.compareTo(c.key) < 0) {
                c = c.left;
            } else if (key.compareTo(c.key) > 0) {
                c = c.right;
            } else {
                return c;
            }
        }
        return null;
    }

    public Node<T> successor(final Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        if (node.right != null) {
            return smallestNodeBefore(node.right);
        }
        Node<T> c = node;
        Node<T> p = node.parent;
        while (p != null && p.right == c) {
            c = p;
            p = c.parent;
        }
        return p;
    }

    public Node<T> smallestNodeBefore(final Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        Node<T> curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public boolean putAll(Collection<T> keys) {
        for (final T key : keys) {
            if (!insert(key)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    public static <E extends Comparable<E>> BinarySearchTree<E> of(
            final E... keyArray) {
        final List<E> keys = Arrays.asList(keyArray);
        final BinarySearchTree<E> tree = new BinarySearchTree<E>();
        for (final E key : keys) {
            tree.insert(key);
        }
        return tree;
    }

    public Node<T> firstNode() {
        if (root == null) {
            return null;
        }
        Node<T> curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public Node<T> lastNode() {
        if (root == null) {
            return null;
        }
        Node<T> curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    private int getDepth(Node<T> node) {
        int level = 0;
        if (root == null) {
            return -1;
        }

        Node<T> c = root;
        T key = node.key;
        while (c != null) {
            if (key.compareTo(c.key) < 0) {
                c = c.left;
                level++;
            } else if (key.compareTo(c.key) > 0) {
                c = c.right;
                level++;
            } else {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid node");
    }

    // Iterable API ========================================
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * DFSIterable API
     */
    @Override
    public PreOrderIterator<T> preOrderIterator() {
        return new BSTTPreOrderIterator(root);
    }

    private final class BSTTPreOrderIterator implements PreOrderIterator<T> {
        private Node<T> lastReturned;
        private final Deque<Node<T>> stack;

        public BSTTPreOrderIterator(Node<T> first) {
            stack = new ArrayDeque<Node<T>>();
            stack.push(first);
        }

        @Override
        public T next() {
            Node<T> next = stack.pop();
            if (next.right != null) {
                stack.push(next.right);
            }
            if (next.left != null) {
                stack.push(next.left);
            }
            return next.key;
        }

        @Override
        public boolean hasNext() {
            return !(stack.isEmpty());
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            delete(lastReturned);
        }
    }

    @Override
    public InOrderIterator<T> inOrderIterator() {
        return new BSTInOrderIterator(firstNode());
    }

    private final class BSTInOrderIterator implements InOrderIterator<T> {
        private Node<T> lastReturned;
        private final Node<T> nextToReturn;

        public BSTInOrderIterator(Node<T> first) {
            if (first == null) {
                throw new IllegalArgumentException();
            }
            lastReturned = null;
            nextToReturn = first;
        }

        @Override
        public boolean hasNext() {
            if (lastReturned == null) {
                return successor(nextToReturn) != null;
            } else {
                return successor(lastReturned) != null;
            }

        }

        @Override
        public T next() {
            if (lastReturned != null) {
                lastReturned = successor(lastReturned);
                return lastReturned.key;
            } else {
                lastReturned = nextToReturn;
                return nextToReturn.key;
            }
        }

        @Override
        public void remove() {
            delete(lastReturned);
        }
    }

    @Override
    public PostOrderIterator<T> postOrderIterator() {
        return new BSTPostOrderIterator(firstNode());
    }

    /**
     * http://www.leetcode.com/2010/10/binary-tree-post-order-traversal.html
     * 
     * @author zhaxinyu
     * 
     */
    private final class BSTPostOrderIterator implements PostOrderIterator<T> {
        private final Deque<Node<T>> stack;
        private Node<T> lastReturned;
        private Node<T> nextToReturn;

        public BSTPostOrderIterator(final Node<T> first) {
            stack = new ArrayDeque<Node<T>>();
            stack.push(first);
            lastReturned = null;
            nextToReturn = first;
        }

        @Override
        public boolean hasNext() {
            // return !stack.isEmpty();
            return nextToReturn != null;
        }

        @Override
        public T next() {
            if (lastReturned == null || nextToReturn == lastReturned.parent
                    && nextToReturn.right == lastReturned) {
                lastReturned = nextToReturn;
            } else if (nextToReturn == lastReturned.parent
                    && nextToReturn.left == lastReturned) {
                Node<T> p = nextToReturn.right;
                while (p != null) {
                    if (p.left != null) {
                        p = p.left;
                    } else if (p.right != null) {
                        p = p.right;
                    } else {
                        break;
                    }
                }
                if (p != null) {
                    lastReturned = p;
                } else {
                    lastReturned = nextToReturn;
                }
            }
            nextToReturn = lastReturned.parent;
            return lastReturned.key;
        }

        @Override
        public void remove() {
            delete(lastReturned);
        }
    }

    // BFS API =======================================
    @Override
    public BFSIterator<T> bsfIterator() {
        return new BSTBFSIterator(root);
    }

    private final class BSTBFSIterator implements BFSIterator<T> {
        private final Deque<Node<T>> nodeQ;
        private final Deque<Integer> levelQ;
        private Node<T> lastReturned;
        private int lastReturnedLevel = -1;

        public BSTBFSIterator(Node<T> first) {
            nodeQ = new ArrayDeque<Node<T>>();
            levelQ = new ArrayDeque<Integer>();
            if (root != null) {
                nodeQ.addLast(root);
                levelQ.addLast(1);
            }
            lastReturned = null;
            lastReturnedLevel = 0;
        }

        @Override
        public boolean hasNext() {
            return !(nodeQ.isEmpty());
        }

        @Override
        public T next() {
            lastReturned = nodeQ.pollFirst();
            lastReturnedLevel = levelQ.pollFirst();
            if (lastReturned.left != null) {
                nodeQ.addLast(lastReturned.left);
                levelQ.addLast(lastReturnedLevel + 1);
            }

            if (lastReturned.right != null) {
                nodeQ.addLast(lastReturned.right);
                levelQ.addLast(lastReturnedLevel + 1);
            }
            return lastReturned.key;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            } else {
                delete(lastReturned);
            }
        }

        @Override
        public int getLevel() {
            return lastReturnedLevel;
        }
    }
}
