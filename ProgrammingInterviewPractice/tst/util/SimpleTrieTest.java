package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleTrieTest {
    @Test
    public void testPut() {
        Trie<Integer> trie = new SimpleTrie<Integer>();
        assertEquals(0, trie.size());
        trie.put("Banana", 1);
        assertEquals(1, trie.size());
        trie.put("anana", 2);
        assertEquals(2, trie.size());
        trie.put("nana", 3);
        assertTrue(trie.get("Banana").equals(1));
        assertTrue(trie.containsKey("Banana"));
        assertFalse(trie.containsKey("Apple"));
        assertFalse(trie.containsKey("Banananana"));
        assertFalse(trie.containsKey("a"));
        assertTrue(trie.containsAsPrefix("a"));
    }

    @Test
    public void testRemove() {
        Trie<Integer> trie = new SimpleTrie<Integer>();
        trie.put("Banana", 1);
        trie.put("anana", 2);
        trie.put("ana", 3);
        assertTrue(trie.remove("anana"));
        assertFalse(trie.containsKey("anana"));
    }

}
