package util;

import org.junit.Test;

public class SimpleSuffixTreeTest {
    @Test
    public void testPatternSearch() {
        String s = "The big cat ate the small catfish";
        String p = "cat";

        SuffixTree stree = new SimpleSuffixTree(s);
        assertEquals(8, stree.find(p));
    }
}
