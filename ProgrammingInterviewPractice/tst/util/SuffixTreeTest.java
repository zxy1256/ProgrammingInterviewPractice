package util;

import org.junit.Test;

public class SuffixTreeTest {
    @Test
    public void testConstruction() {
        SuffixTree suffixTree = new SuffixTree("ABCD");
        System.out.println(suffixTree.toString());
    }
}
