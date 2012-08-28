package careerCup3.ch12;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Ch12_6 {
    public static List<Integer> addLinkedList(List<Integer> l1, List<Integer> l2) {
        final Deque<Integer> s1 = pushAllToStack(l1);
        final Deque<Integer> s2 = pushAllToStack(l2);

        List<Integer> result = new LinkedList<Integer>();

        int carryon = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carryon;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            carryon = sum > 10 ? 1 : 0;
            result.add(0, sum > 10 ? sum - 10 : sum);
        }
        return result;
    }

    private static <T> Deque<T> pushAllToStack(List<T> list) {
        Deque<T> stack = new ArrayDeque<T>();
        for (T node : list) {
            stack.push(node);
        }
        return stack;
    }
}
