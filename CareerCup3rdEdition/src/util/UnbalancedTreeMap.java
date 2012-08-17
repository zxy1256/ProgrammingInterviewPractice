package util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple unbalanced binary search tree.
 * 
 * Does not support comparator.
 * 
 * @author Sean
 *
 * @param <K>
 * @param <V>
 */
final public class UnbalancedTreeMap<K,V>
	extends AbstractMap<K,V>
	implements BFSIterable<Map.Entry<K, V>>
{

	private transient Entry<K, V> root = null;
	private transient int size;

	// Basic Tree Operations ================================ 
	public static final class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;
		Entry<K, V> left = null;
		Entry<K, V> right = null;
		Entry<K, V> parent = null;
		
		Entry(K key, V value, Entry<K, V> parent) {
			this.key = key;
			this.value = value;
			this.parent = parent;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
		
		public boolean equals(Object o) {
			if (! (o instanceof Map.Entry)) {
				return false;
			}
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

			return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
		}
		
		public int hashCode() {
			int keyHash = (key == null? 0 : key.hashCode());
			int valueHash = (value == null? 0 : value.hashCode());
			return keyHash ^ valueHash;
		}
		
		public String toString() {
			return key + "=>" + value;
		}
	}
	
	static <K, V> UnbalancedTreeMap.Entry<K, V> successor(Entry<K, V> e) {
		if (e == null) {
			return null;
		}
		if (e.right != null) {
			Entry<K, V> next = e.right;
			while (next.left != null) {
				next = next.left;
			}
			return next;
		} else {
			Entry<K, V> parent = e.parent;
			Entry<K, V> child = e;
			while (parent != null && child == parent.right) {
				child = parent;
				parent = child.parent;
			}
			return parent;
		}
	}
	
	/**
	 * Delete entry e
	 * @param e
	 */
//	void deleteEntry(Entry<K, V> e) {
//		if (e.left == null && e.right == null) {
//			if (e.parent == null) {
//				root = null;
//			}
//			if (e == e.parent.left) {
//				e.parent.left = null;
//			} else {
//				e.parent.right = null;
//			}
//		}
//		
//		if (e.left != null && e.right == null) {
//			if (e.parent == null) {
//				root = e.left;
//				e.left.parent = root;
//			}
//			
//			if (e == e.parent.left) {
//				e.parent.left = e.left;
//				e.left.parent = e.parent;
//			}
//			
//			if (e == e.parent.right) {
//				e.parent.right = e.left;
//				e.left.parent = e.parent;
//			}
//		}
//		
//		if (e.right != null && e.left == null) {
//			if (e.parent == null) {
//				root = e.right;
//				e.right.parent = root;
//			}
//			
//			if (e == e.parent.left) {
//				e.parent.left = e.right;
//				e.right.parent = e.parent;
//			}
//			
//			if (e == e.parent.right) {
//				e.parent.right = e.right;
//				e.right.parent = e.parent;
//			}
//		}
//		
//		if (e.left != null && e.right != null) {
//			if (e.parent == null) {
//				root = e.left;
//				e.left.parent = root;
//			} else if (e==e.parent.left) {
//				e.parent.left = e.left;
//				e.left.parent = e.parent;
//			} else {
//				e.parent.right = e.left;
//				e.left.parent = e.parent;
//			}
//			
//			Entry<K, V> leftCh = e.left;
//			while(leftCh.right!=null) {
//				leftCh = leftCh.right;
//			}
//			leftCh.right = e.right;
//			e.right.parent = leftCh;
//			e.right = null;
//		}
//		
//		return;
//	}
	
	private void deleteEntry(Entry<K, V> e) {
		size--;
		
		Entry<K, V> y = (e.left == null || e.right == null)? e: successor(e);
		Entry<K, V> x = y.left == null ? y.right : y.left;
		if (x != null) {
			x.parent = y.parent;
		}
		if (y.parent == null) {
			root = x;
		} else {
			if (y == y.parent.left) {
				y.parent.left = x;
			} else {
				y.parent.right = x;
			}
		}
		if (y != e) {
			e.key = y.key;
			e.value = y.value;
		}
	}

	
	// Map APIs ===========================================
	public int size() {
		return size;
	}
	
	public boolean containsKey(Object key) {
		return getEntry(key) != null;
	}
	
	public boolean containsValue(Object value) {
		for (Entry<K, V> e = getFirstEntry(); e != null; e = successor(e)) {
			if (valEquals(e, value)) {
				return true;
			}
		}
		return false;
	}
	
	// Provides the EntrySet view 
	private transient EntrySet entrySet = null;
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return entrySet != null? entrySet: (entrySet = new EntrySet());
	}
	
	class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		
		public EntrySet() {
			this.add();
		}

		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return new EntryIterator(getFirstEntry());
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	class EntryIterator implements Iterator<Map.Entry<K,V>> {

		Entry<K, V> next;
		Entry<K, V> lastReturned;
		
		public EntryIterator(Entry<K, V> first) {
			next = first;
			lastReturned = null;
		}
		
		@Override
		public boolean hasNext() {
			return (successor(next) == null);
		}

		@Override
		public Entry<K, V> next() {
			lastReturned = next;
			return next;
		}

		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException("remove() can only called once for every next().");
			}
			deleteEntry(lastReturned);
		}
	}

	public V put(K key, V value) {
		if (key == null) {
			throw new NullPointerException();
		}
		
		if (root == null) {
			root = new Entry<K, V>(key, value, null);
			size = 1;
			root.parent = null;
			return value;
		}
		
		size++;
		
		Entry<K, V> ch = root;
		Entry<K, V> parent = null;
		@SuppressWarnings("unchecked")
		Comparable<? super K> k = (Comparable<? super K>) key;
		
		while (ch != null) {
			if (k.compareTo(ch.key) < 0) {
				parent = ch;
				ch = ch.left;
			} else if (k.compareTo(ch.key) > 0) {
				parent = ch;
				ch = ch.right;
			} else {
				V oldValue = ch.value;
				ch.value = value;
				return oldValue;
			}
		}
		
		if (k.compareTo(parent.key) < 0) {
			parent.left = new Entry<K, V>(key, value, parent);
		} else {
			parent.right = new Entry<K, V>(key, value, parent);
		}
		return value;
	}
	
	public V get(Object keyObject) {
		Entry<K, V> e = getEntry(keyObject);
		return e == null? null : e.value;
	}
	
	public void clear() {
		size = 0;
		root = null;
	}
	
	// DFSIterable APIs ====================================
	
	final class PreOrderIterator implements Iterator<Map.Entry<K, V>> {
		private Entry<K, V> lastReturned;
		private Deque<Entry<K, V>> stack;
		
		public PreOrderIterator(Entry<K, V> first) {
			stack.push(first);
		}
		
		public PreOrderIterator() {
			stack.push(root);
		}
		
		public Map.Entry<K, V> next() {
			Entry<K, V> next = stack.pop();
			stack.push(next.right);
			stack.push(next.left);
			return next;
		}

		@Override
		public boolean hasNext() {
			return stack.isEmpty();
		}

		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}
			
			deleteEntry(lastReturned);
		}
	}
	
	// BSFIterable APIs ====================================
	public BFSIterator<Map.Entry<K, V>> bsfIterator() {
		return new MapBFSIterator();
	}
	
	public final class MapBFSIterator implements BFSIterator<Map.Entry<K, V>> {
		private Entry<K, V> lastReturned;
		private int level;
		private Deque<Entry<K, V>> queue;
		private Deque<Integer> levelQueue;
		
		public MapBFSIterator() {
			lastReturned = null;
			level = -1;
			queue.addFirst(root);
			levelQueue.addFirst(0);
			
		}

		@Override
		public boolean hasNext() {
			return queue.isEmpty();
		}

		@Override
		public java.util.Map.Entry<K, V> next() {
			lastReturned = queue.poll();
			level = levelQueue.poll();
			if (lastReturned != null) {
				queue.addLast(lastReturned.left);
				levelQueue.addLast(level+1);
				queue.addLast(lastReturned.right);
				levelQueue.addLast(level+1);
			}
			return lastReturned;
		}

		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}
			deleteEntry(lastReturned);
		}
		
		public int getLevel() {
			return level;
		}
		
	}

	// 
	public Entry<K, V> getFirstEntry() {
		if (root == null) {
			return null;
		}
		Entry<K, V> curr = root;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}
	
	final static boolean valEquals(Object o1, Object o2) {
		return (o1==null ? o2==null : o1.equals(o2));
	}
	
	public Entry<K, V> getEntry(Object keyObject) {
		Comparable<? super K> key = (Comparable<? super K>) keyObject;
		Entry<K, V> ch = root;
		while (ch != null) {
			if (key.compareTo(ch.key) < 0) {
				ch = ch.left;
			} else if (key.compareTo(ch.key) > 0) {
				ch = ch.right;
			} else {
				return ch;
			}
		}
		return null;
	}
		
	public static <K, V> UnbalancedTreeMap<K, V> of(List<K> keys, List<V> values) {
		UnbalancedTreeMap<K, V> m = new UnbalancedTreeMap<K, V>();
		if (keys.size() != values.size()) {
			throw new IllegalArgumentException("The number of keys must match the number of values.");
		}
		Iterator<K> keyIterator = keys.iterator();
		Iterator<V> valueIterator = values.iterator();
		while (keyIterator.hasNext()) {
			m.put(keyIterator.next(), valueIterator.next());
		}
		return m;
	}
}
