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
    private Trie mTrie;

    public SimpleSuffixTree(String s) {
        mTrie = new SimpleTrie();
        if (s == null) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            mTrie.put(s.substring(i));
        }
    }

    @Override
    public int find(String p) {
        return 0;
    }
}
