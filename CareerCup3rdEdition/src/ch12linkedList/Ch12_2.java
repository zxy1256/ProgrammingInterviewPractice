package ch12linkedList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Ch12_2 {
	public static <T> void removeDuplicateElement(List<T> list) {
		final Set<T> elements = new HashSet<T>();
		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (elements.contains(element)) {
				iterator.remove();
			} else {
				elements.add(element);
			}
		}
		System.out.println(list);
	}
	
}
