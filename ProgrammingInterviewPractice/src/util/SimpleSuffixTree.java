package util;

/**
 * This is a naive implementation of SuffixTree.
 * 
 * For more efficient implementation, please see UKKSuffixTree.
 * 
 * @author sean
 * 
 */
public class SimpleSuffixTree implements SuffixTree {
    private Trie<Integer> mTrie;

    public SimpleSuffixTree(String s) {
        mTrie = new SimpleTrie<Integer>();
        if (s == null) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            mTrie.put(s.substring(i), i);
        }
    }

    @Override
    public int find(final String p) {
        return mTrie.get(key);
    }
}
