package careerCup3.ch18;

import java.util.ArrayList;
import java.util.List;

import util.SimpleSuffixTree;
import util.SuffixTree;

public class Ch18_4 {
    public static List<Integer> findSubstring(final String s,
            List<String> patterns) {
        SuffixTree st = new SimpleSuffixTree(s);
        List<Integer> result = new ArrayList<Integer>();
        for (String p : patterns) {
            result.add(st.find(p));
        }
        return result;
    }
}
