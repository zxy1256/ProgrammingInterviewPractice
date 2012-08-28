package util;

import java.util.Iterator;
import java.util.List;

/**
 * A utility class for List
 * 
 * @author zhaxinyu
 * 
 */
public class ListUtil {
    public static <T> void print(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + (it.hasNext() ? "," : ""));
        }
        System.out.println("");
    }

    public static <T> boolean isEqual(List<T> l1, List<T> l2) {
        return false;
    }
}
