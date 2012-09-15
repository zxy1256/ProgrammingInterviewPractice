package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleTrieTest {
    @Test
    public void testPut() {
        Trie trie = new SimpleTrie();
        assertEquals(0, trie.size());
        trie.put("Banana");
        assertEquals(1, trie.size());
        trie.put("anana");
        assertEquals(2, trie.size());
        trie.put("nana");
        assertTrue(trie.contains("Banana"));
        assertFalse(trie.contains("Apple"));
        assertFalse(trie.contains("Banananana"));
        assertFalse(trie.contains("a"));
        assertEquals(3, trie.size());
    }

    @Test
    public void testRemove() {
        Trie trie = new SimpleTrie();
        trie.put("Banana");
        trie.put("anana");
        trie.put("ana");
        assertTrue(trie.remove("anana"));
        assertFalse(trie.contains("anana"));
        trie.put("Bank");
        trie.remove("Bank");
        assertFalse(trie.contains("Bank"));
    }
}
