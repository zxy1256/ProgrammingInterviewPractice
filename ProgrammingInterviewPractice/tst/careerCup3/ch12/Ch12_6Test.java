package careerCup3.ch12;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import util.ListUtil;

public class Ch12_6Test {
    @Test
    public void testNoCarryOn() {
        test(Arrays.asList(1, 1, 1), Arrays.asList(2, 2, 2));
    }

    @Test
    public void testWithCarryOn() {
        test(Arrays.asList(1), Arrays.asList(9, 9, 9));
    }

    private void test(List<Integer> l1, List<Integer> l2) {
        ListUtil.print(Ch12_6.addLinkedList(l1, l2));
    }
}
