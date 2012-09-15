package util;

/**
 * For simplicity, a naive O(n^3) time and O(n^2) space algorithm is used.
 * 
 * @author sean
 * 
 */
public interface SuffixTree {
    /**
     * Search a pattern in this SuffixTree.
     * 
     * @param pattern
     * @return the index where the pattern first appears. Index starts from 0.
     */
    public int find(String pattern);
}
