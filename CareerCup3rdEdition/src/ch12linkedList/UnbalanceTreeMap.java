package ch12linkedList;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UnbalanceTreeMap<K,V>
	extends AbstractMap<K,V>
{

	private Entry<K, V> root;
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
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
	
	final static boolean valEquals(Object o1, Object o2) {
		return (o1==null ? o2==null : o1.equals(o2));
	}
	
	// Tree Operations
	static final class Entry<K, V> implements Map.Entry<K, V> {
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
	
	static <K, V> UnbalanceTreeMap.Entry<K, V> successor(Entry<K, V> e) {
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
	void deleteEntry(Entry<K, V> e) {
		if (e.left == null && e.right == null) {
			if (e.parent == null) {
				root = null;
			}
			if (e == e.parent.left) {
				e.parent.left = null;
			} else {
				e.parent.right = null;
			}
			return;
		}
		
		if (e.left != null && e.right != null) {
			if (e.parent == null) {
				root = e.left;
			} else if (e==e.parent.left) {
				e.parent.left = e.left;
			} else {
				e.parent.right = e.left;
			}
			
			Entry<K, V> leftCh = e.left;
			while(leftCh.right!=null) {
				leftCh = leftCh.right;
			}
			leftCh.right = e.right;
			e.right.parent = leftCh;
			e.right = null;
		}
	}
}
