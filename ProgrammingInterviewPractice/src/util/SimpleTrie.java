package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * With one character per edge (i.e., node could have only one child).
 * 
 * See also: CompactTrie
 * 
 * @author sean
 * 
 */
public class SimpleTrie<V> implements Trie<V> {
    public static String TERMINAL_CHAR = "$";

    private static class Node<V> {
        String label;
        Map<String, Node<V>> children;
        Node<V> parent;
        V value;

        Node(String label, Node<V> parent, V value) {
            this.label = label;
            this.parent = parent;
            children = new TreeMap<String, Node<V>>();
            this.value = value;
        }

        void put(List<String> keyChars, V value) {
            if (keyChars == null || keyChars.isEmpty()) {
                return;
            }
            final String edgeLabel = keyChars.get(0);
            if (!children.containsKey(edgeLabel)) {
                children.put(edgeLabel, new Node<V>(edgeLabel, this, null));
            }
            if (keyChars.size() > 1) {
                children.get(edgeLabel).put(
                        keyChars.subList(1, keyChars.size()), value);
            } else {
                children.get(edgeLabel).value = value;
            }
        }

        V get(List<String> keyChars) {
            if (keyChars == null || keyChars.isEmpty()) {
                return value;
            }
            final String edgeLabel = keyChars.get(0);
            if (children.containsKey(edgeLabel)) {
                if (keyChars.size() > 1) {
                    return children.get(edgeLabel).get(
                            keyChars.subList(1, keyChars.size()));
                } else {
                    return children.get(edgeLabel).value;
                }
            }
            return null;
        }

        Map<String, V> getAsPrefix(List<String> prefixChars) {
            if (prefixChars == null || prefixChars.isEmpty()) {
                // return all the 
                return children
            }
            final String edgeLabel = prefixChars.get(0);
            if (children)
            Collection<V> result = new ArrayList<V>();
            
            return result;
        }

        boolean remove(List<String> keyChars) {
            if (keyChars == null || keyChars.isEmpty()) {
                return true;
            }
            final String edgeLabel = keyChars.get(0);
            if (children.containsKey(edgeLabel)) {
                if (keyChars.size() == 1) {
                    children.remove(edgeLabel);
                    return true;
                } else {
                    Node<V> child = children.get(edgeLabel);
                    child.remove(keyChars.subList(1, keyChars.size()));
                    if (child.children.isEmpty()) {
                        children.remove(edgeLabel);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private final Node<V> root;
    private int size;

    public SimpleTrie() {
        root = new Node<V>(null, null, null);
    }

    @Override
    public void put(String key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        List<String> keyChars = breakToSingleCharList(key);
        root.put(keyChars, value);
        size++;
    }

    private List<String> breakToSingleCharList(String key) {
        char[] keyCharArray = key.toCharArray();
        List<String> keyChars = new ArrayList<String>(keyCharArray.length);
        for (char c : keyCharArray) {
            keyChars.add(String.valueOf(c));
        }
        keyChars.add(TERMINAL_CHAR);
        return keyChars;
    }

    @Override
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    @Override
    public boolean remove(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        List<String> keyChars = breakToSingleCharList(key);
        boolean result = root.remove(keyChars);
        if (result) {
            size--;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        List<String> keyChars = breakToSingleCharList(key);
        return root.get(keyChars);
    }

    @Override
    public boolean containsAsPrefix(String prefix) {
        return !(getByPrefix(prefix).isEmpty());
    }

    @Override
    public Collection<V> getByPrefix(String prefix) {
        if (prefix == null) {
            throw new NullPointerException();
        }
        List<String> keyChars = breakToSingleCharList(prefix);
        return null;
    }
}
