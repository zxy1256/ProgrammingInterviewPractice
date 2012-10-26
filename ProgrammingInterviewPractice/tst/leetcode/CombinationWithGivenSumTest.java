package leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import util.ListUtil;

public class CombinationWithGivenSumTest {
    @Test
    public void test() {
        CombinationWithGivenSum problem = new CombinationWithGivenSum();
        List<List<Integer>> result = problem
                .solve(7, Arrays.asList(2, 3, 6, 7));
        for (List<Integer> l : result) {
            ListUtil.print(l);
        }
    }

    @Test
    public void test2() {
        CombinationWithGivenSum problem = new CombinationWithGivenSum();
        List<List<Integer>> result = problem.solve(7,
                Arrays.asList(1, 2, 3, 6, 7));
        for (List<Integer> l : result) {
            ListUtil.print(l);
        }
    }

    @Test
    public void test3() {
        CombinationWithGivenSum problem = new CombinationWithGivenSum();
        List<List<Integer>> result = problem.solve(9, Arrays.asList(3, 5, 7));
        for (List<Integer> l : result) {
            ListUtil.print(l);
        }
    }
}
