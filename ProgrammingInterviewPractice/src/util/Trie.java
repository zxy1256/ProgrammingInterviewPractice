package util;

import java.util.Collection;

/**
 * Trie (also called Prefix tree).
 * 
 * @author sean
 * 
 */
public interface Trie<V> {
    public void put(String key, V value);

    public V get(String key);

    public boolean containsKey(String key);

    public boolean remove(String key);

    public boolean containsAsPrefix(String prefix);

    public Collection<V> getByPrefix(String prefix);

    public int size();
}
