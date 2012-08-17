package util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.UnbalancedTreeMap;
import static org.junit.Assert.*;

public class UnbalanceTreeMapTest {
	
	/*
	 * Test of Map APIs
	 * 1. void clear()
	 * 2. boolean containsKey(Object key)
	 * 3. boolean containsValue(Object value)
	 * 4. entrySet()
	 * 5. equals()
	 * 6. get(Object key)
	 * 7. hashCode()
	 * 8. isEmpty()
	 * 9. Set<Map.Entry<K, V>> keySet()
	 * 10. V put(K key, V value)
	 * 11. void putAll(Map<? extends K, ? extends V>
	 * 12. V remove(Object key)
	 * 13. int size()
	 * 14. Collection<V> values()
	 * 
	 * Test for DFS traversal
	 * 1. PreOrderIterator preOrderIterator()
	 * 2. InOrderIterator inOrderIterator()
	 * 3. PostOrderIterator postOrderIterator()
	 * 
	 * Test for BFS traversal
	 * 1. BFSIterator BFSIterator();
	 * 
	 * Test for additional static factory method
	 * 1. UnbalancedTreeMap of(List<K> keys, List<V> values)
	 */
 
	
	
	@Test
	public void testGeneration() {
		List<String> keys = Arrays.asList("a","b","c","d");
		List<Integer> values = Arrays.asList(1, 2, 3, 4);
		Map<String, Integer> map = UnbalancedTreeMap.of(keys, values);
		System.out.println(map.get("Apple"));
		MapUtil.printMap(map);
		assertEquals(4, map.size());
	}
	
	@Test
	public void testPreOrderTransversal() {
		
	}
}
