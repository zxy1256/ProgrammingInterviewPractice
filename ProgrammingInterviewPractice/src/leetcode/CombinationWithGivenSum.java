package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.leetcode.com/2010/09/print-all-combinations-of-number-as-sum.html
 * 
 * Tag: backtracking, recursive
 */
public class CombinationWithGivenSum {
    public List<List<Integer>> solve(int target, List<Integer> candidates) {
        Deque<Combination> q = new LinkedList<Combination>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i : candidates) {
            q.addLast(new Combination(i));
        }

        while (!q.isEmpty()) {
            Combination c = q.poll();
            if (c.sum == target) {
                result.add(c.digits);
            } else if (c.sum < target) {
                for (int i : candidates) {
                    if (i >= c.max) {
                        Combination newCombination = new Combination(c);
                        newCombination.add(i);
                        q.addLast(newCombination);
                    }
                }
            }
        }
        return result;
    }

    private class Combination {
        public Combination(int element) {
            sum = element;
            max = element;
            digits = new LinkedList<Integer>();
            digits.add(element);
        }

        public Combination(Combination c) {
            sum = c.sum;
            max = c.max;
            digits = new LinkedList<Integer>();
            digits.addAll(c.digits);
        }

        List<Integer> digits;
        int sum;
        int max;

        int add(int element) {
            digits.add(element);
            sum += element;
            if (element > max) {
                max = element;
            }
            return sum;
        }

    }
}
