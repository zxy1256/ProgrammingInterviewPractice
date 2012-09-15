package util;

/**
 * Trie (also called Prefix tree).
 * 
 * @author sean
 * 
 */
public interface Trie {
    public void put(String key);

    public boolean contains(String key);

    public boolean remove(String key);

    public int size();
}
