package careerCup3.ch18;

import java.util.List;

public class Ch18_3 {
    public static <T extends Comparable<T>> int search(List<T> c, T target) {
        int l = 0;
        int h = c.size() - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            T lv = c.get(l);
            T mv = c.get(m);
            T hv = c.get(h);
            if (target.compareTo(mv) == 0) {
                return m;
            }
            if (lv.compareTo(hv) <= 0) {
                if (target.compareTo(mv) < 0) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (mv.compareTo(lv) >= 0) {
                    if (target.compareTo(mv) > 0) {
                        l = m + 1;
                    } else if (target.compareTo(hv) <= 0) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                } else {
                    if (target.compareTo(mv) < 0) {
                        h = m - 1;
                    } else if (target.compareTo(lv) >= 0) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
        }
        return -1;
    }
}
