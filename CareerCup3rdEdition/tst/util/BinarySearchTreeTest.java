package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void testGeneration() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(1,2,3,4);
        assertEquals(4, tree.size());
    }

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(1,2,3,4);
        tree.insert(5);
        assertEquals(5, tree.size());
        tree.delete(tree.getNode(1));
        assertEquals(4, tree.size());
        tree.delete(tree.getNode(2));
        assertEquals(3, tree.size());
    }

    @Test
    public void testBFSIteratorHappyCase() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(5,2,7,1,3,6,8);
        BFSIterator<Integer> iterator = tree.bsfIterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int level = iterator.getLevel();
            System.out.println(level + " : " + key);
        }
    }
    
    @Test
    public void testBFSIteratorEmtpyTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        BFSIterator<Integer> iterator = tree.bsfIterator();
        assertFalse(iterator.hasNext());
    }
}
