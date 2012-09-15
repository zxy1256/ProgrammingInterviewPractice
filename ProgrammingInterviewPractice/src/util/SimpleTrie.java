package util;

import java.util.ArrayList;
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
public class SimpleTrie implements Trie {
    private static class Node {
        String label;
        Map<String, Node> children;
        Node parent;

        public Node(String label, Node parent) {
            this.label = label;
            this.parent = parent;
            children = new TreeMap<String, Node>();
        }

        public void put(List<String> keyChars) {
            if (keyChars == null || keyChars.isEmpty()) {
                return;
            }
            final String edgeLabel = keyChars.get(0);
            if (!children.containsKey(edgeLabel)) {
                children.put(edgeLabel, new Node(edgeLabel, this));
            }
            if (keyChars.size() > 1) {
                children.get(edgeLabel).put(
                        keyChars.subList(1, keyChars.size()));
            }
        }

        public boolean contains(List<String> keyChars) {
            if (keyChars == null || keyChars.isEmpty()) {
                return true;
            }
            final String edgeLabel = keyChars.get(0);
            if (children.containsKey(edgeLabel)) {
                if (keyChars.size() > 1) {
                    return children.get(edgeLabel).contains(
                            keyChars.subList(1, keyChars.size()));
                } else {
                    return true;
                }
            }
            return false;
        }

        public boolean remove(List<String> keyChars) {
            if (keyChars == null || keyChars.isEmpty()) {
                return true;
            }
            final String edgeLabel = keyChars.get(0);
            if (children.containsKey(edgeLabel)) {
                if (keyChars.size() == 1) {
                    children.remove(edgeLabel);
                    return true;
                } else {
                    Node child = children.get(edgeLabel);
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

    private final Node root;
    private int size;

    public SimpleTrie() {
        root = new Node(null, null);
    }

    @Override
    public void put(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        List<String> keyChars = breakToSingleCharList(key);
        root.put(keyChars);
        size++;
    }

    private List<String> breakToSingleCharList(String key) {
        char[] keyCharArray = key.toCharArray();
        List<String> keyChars = new ArrayList<String>(keyCharArray.length);
        for (char c : keyCharArray) {
            keyChars.add(String.valueOf(c));
        }
        keyChars.add("$");
        return keyChars;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        List<String> keyChars = breakToSingleCharList(key);
        return root.contains(keyChars);
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

}
