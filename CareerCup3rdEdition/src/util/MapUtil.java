package util;

import java.util.Iterator;
import java.util.Map;

public class MapUtil {
	public static <K, V> void  printMap(Map<K, V> m) {
		if (m==null) {
			return;
		}
		
		Iterator<Map.Entry<K, V>> iterator = m.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<K, V> entry = iterator.next();
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}
}
