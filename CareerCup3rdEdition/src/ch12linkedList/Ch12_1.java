package ch12linkedList;

import java.util.Iterator;
import java.util.List;


public class Ch12_1 {
	public static <T> T getNthLastElement(List<T> list, int n) {
		Iterator<T> iterator1 = list.iterator();
		Iterator<T> iterator2 = list.iterator();
		
		int counter = 0;
		while (iterator1.hasNext()) {
			if (counter > n) {
				iterator2.next();
			}
			iterator1.next();
			counter++;
		}
		
		if (counter<=n) {
			return null;
		} else {
			return iterator2.next();
		}
	}
}
