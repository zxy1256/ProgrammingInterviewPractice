package leetcode;

import java.util.List;

public class MedianOfTwoSortedLists {
    public Integer getMedian(final List<Integer> la, final List<Integer> lb,
            int left, int right) {
        int n = la.size() + lb.size();
        int i = (left + right) / 2;
        int j = ((int) Math.ceil(n / 2.0)) - i;

    }
}
