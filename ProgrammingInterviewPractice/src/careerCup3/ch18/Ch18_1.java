package careerCup3.ch18;

import java.util.Vector;

public class Ch18_1 {
    /**
     * Merge Vector b to Vector a.
     * 
     * @param a
     * @param b
     */
    public static <T extends Comparable<T>> Vector<T> mergeSortedArray(
            Vector<T> a, final Vector<T> b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }

        int ia = a.size() - 1;
        int ib = b.size() - 1;
        a.addAll(b); // Expand a so that it can hold all the element
        int index = a.size() - 1;
        while (ia >= 0 && ib >= 0) {
            T va = a.get(ia);
            T vb = b.get(ib);
            if (va.compareTo(vb) >= 0) {
                a.set(index, va);
                ia--;
            } else {
                a.set(index, vb);
                ib--;
            }
            index--;
        }
        if (ia >= 0) {
            while (ia >= 0) {
                a.set(index, a.get(ia));
                ia--;
                index--;
            }
        } else {
            while (ib >= 0) {
                a.set(index, b.get(ib));
                ib--;
                index--;
            }
        }
        return a;
    }

}
