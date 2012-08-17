package util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void testGeneration() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(1,2,3,4);
        assertEquals(4, tree.size());
    }
    
    @Test
    public void testBFSTraversal() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(5,2,7,1,3,6,8);
        BFSIterator<Integer> iterator = tree.bsfIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getLevel() + " : " + iterator.next());
        }
    }
}
