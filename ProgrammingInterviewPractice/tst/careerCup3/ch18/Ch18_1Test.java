package careerCup3.ch18;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

import util.ListUtil;

public class Ch18_1Test {
    @Test
    public void happyEqualLengthWithEqualElements() {
        Vector<Integer> a = new Vector<Integer>(Arrays.asList(1, 2, 3, 4));
        Vector<Integer> b = new Vector<Integer>(Arrays.asList(1, 2, 3, 4));

        a = Ch18_1.mergeSortedArray(a, b);

        ListUtil.print(a);
    }

    @Test
    public void happyNoEqualLength() {
        Vector<Integer> a = new Vector<Integer>(Arrays.asList(1));
        Vector<Integer> b = new Vector<Integer>(Arrays.asList(1, 3, 4, 5));

        a = Ch18_1.mergeSortedArray(a, b);

        ListUtil.print(a);
    }
}
