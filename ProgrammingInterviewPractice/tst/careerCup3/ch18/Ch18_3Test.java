package careerCup3.ch18;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Ch18_3Test {
    @Test
    public void testOneElementList() {
        test(Arrays.asList(1));
    }

    @Test
    public void testTwoElementList() {
        test(Arrays.asList(1, 2));
    }

    @Test
    public void testGapOnTheLeft() {
        test(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testAscendingArray() {
        test(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testGapOnTheRight() {
        test(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 1, 2));
    }

    private void test(List<Integer> l) {
        for (int i = 0; i < l.size(); i++) {
            assertEquals(i, Ch18_3.search(l, l.get(i)));
        }
    }
}
