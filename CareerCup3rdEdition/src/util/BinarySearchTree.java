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
public class BinarySearchTree<T extends Comparable<T>> implements BFSIterable<T>, DFSIterable<T>, Iterable<T> {
    private Node<T> root;
    private int size;
    
    public class Node<E> {
        Node<E> parent;
        Node<E> left;
        Node<E> right;
        E key;

        public Node(Node<E> parent, E key) {
            this.parent = parent;
            this.key = key;
        }
    }

    /*
     * Return true if the key does not exist and insert success.
     * Return false otherwise. 
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
		    if (key.compareTo(c.key) < 0 ) {
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
		    p.left = new Node<T>(null, key);
		} else {
		    p.right = new Node<T>(null, key);
		}
		size++;
        return true;
	}

    public boolean delete(Node<T> n) {
        size--;
        
        Node<T> y = (n.left == null || n.right == null)? n: successor(n);
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
            if (key.compareTo(c.key) < 0 ) {
                c = c.left;
            } else if (key.compareTo(c.key) > 0) {
                c = c.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public Node<T> successor(Node<T> entry) {
        return null;
    }
    
    public boolean putAll(Collection<T> keys) {
        for (final T key: keys) {
            if(!insert(key)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }
    public static <E extends Comparable<E>> BinarySearchTree<E> of(final E... keyArray) {
        final List<E> keys = Arrays.asList(keyArray);
        final BinarySearchTree<E> tree = new BinarySearchTree<E>();
        for (final E key : keys) {
            tree.insert(key);
        }
        return tree;
    }
    
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    // DFSIterable APIs ====================================
    @Override
    public PreOrderIterator<T> preOrderIterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
    final class BSTPreOrderIterator implements PreOrderIterator<T> {
        private Node<T> lastReturned;
        private Deque<Node<T>> stack;
        
        public BSTPreOrderIterator(Node<T> first) {
            stack = new ArrayDeque<Node<T>>();
            stack.push(first);
        }
        
        public BSTPreOrderIterator() {
            stack.push(root);
        }
        
        public T next() {
            Node<T> next = stack.pop();
            stack.push(next.right);
            stack.push(next.left);
            return next.key;
        }

        @Override
        public boolean hasNext() {
            return stack.isEmpty();
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostOrderIterator<T> postOrderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BFSIterator<T> bsfIterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public final class BSTBFSIterator implements BFSIterator<T> {
        private Deque<Node<T>> queue;
        private Deque<Integer> levelQ;
        Node<T> lastReturned;
        
        public BSTBFSIterator(T first) {
            queue = new ArrayDeque<Node<T>>();
            enqueueIfNotNull(root);
            lastReturned = null;
        }
        
        @Override
        public boolean hasNext() {
            return queue.isEmpty();
        }

        @Override
        public T next() {
            lastReturned = queue.pollFirst();
            int lastReturned
            if (lastReturned.left != null) {
                queue.addLast(lastReturned.left);
                levelQ.addLast(e)
            }
            
            enqueueIfNotNull(lastReturned.right);
            return null;
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
            return 0;
        }
        
        private boolean enqueueIfNotNull(Node<T> node) {
            if (node == null) {
                return false;
            } else {
                queue.addLast(node);
                return true;
            }
        }
    }
}
