package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> mUnbalancedTree;
    private BinarySearchTree<Integer> mBalancedTree;
    private BinarySearchTree<Integer> mEmptyTree;
    @Before
    public void setUp() {
        mUnbalancedTree = BinarySearchTree.of(1,2,3,4);
        mBalancedTree = BinarySearchTree.of(5,2,7,1,3,6,8);
        mEmptyTree = new BinarySearchTree<Integer>();
    }
    
    @Test
    public void testGeneration() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(1,2,3,4);
        assertEquals(4, tree.size());
    }

    @Test
    public void testInsert() {
        mUnbalancedTree.insert(5);
        assertEquals(5, mUnbalancedTree.size());
        mUnbalancedTree.delete(mUnbalancedTree.getNode(1));
        assertEquals(4, mUnbalancedTree.size());
        mUnbalancedTree.delete(mUnbalancedTree.getNode(2));
        assertEquals(3, mUnbalancedTree.size());
    }

    @Test
    public void testBFSIteratorHappyCase() {
        BFSIterator<Integer> iterator = mBalancedTree.bsfIterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int level = iterator.getLevel();
            System.out.println(level + " : " + key);
        }
    }
    
    @Test
    public void testBFSIteratorEmtpyTree() {
        BFSIterator<Integer> iterator = mEmptyTree.bsfIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPreOrderIteratorHappyCase() {
        PreOrderIterator<Integer> iterator = mBalancedTree.preOrderIterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.println(key);
        }
    }
    
    @Test
    public void testInOrderIteratorHappyCase() {
        InOrderIterator<Integer> iterator = mBalancedTree.inOrderIterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.println(key);
        }
    }
}
