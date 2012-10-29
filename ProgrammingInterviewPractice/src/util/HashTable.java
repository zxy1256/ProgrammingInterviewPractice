package util;

/**
 * 
 * @author sean
 * 
 * @param <K>
 * @param <V>
 * 
 *            Mistakes I made:
 *            <ol>
 *            <li>float number should be 0.75f instead 0.75</li>
 *            <li>Some invalid variable name</li>
 *            <li>Have unreachable code</li>
 *            <li>Forget to implement the resize/rehash part</li>
 *            </ol>
 * 
 */
public class HashTable<K, V> {
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            key = k;
            value = v;
            this.next = next;
        }

    }

    private static final int MAX_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private int capacity;
    private float loadFactor;
    private transient int size;
    private Entry<K, V>[] table;

    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(final int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(final int initialCapacity, final float loadFactor) {
        capacity = initialCapacity > MAX_CAPACITY ? MAX_CAPACITY
                : initialCapacity;
        table = new Entry[initialCapacity];
        size = 0;
    }

    int hash(int hashCode) {
        return hashCode % capacity;
    }

    public synchronized boolean containsKey(Object key) {
        Entry<K, V> curr = table[hash(key.hashCode())];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }
        return curr != null;
    }

    public synchronized V get(Object key) {
        Entry<K, V> curr = table[hash(key.hashCode())];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        return curr != null ? curr.value : null;
    }

    public synchronized V put(K key, V value) {
        Entry<K, V> head = table[hash(key.hashCode())];
        if (head == null) {
            table[hash(key.hashCode())] = new Entry<K, V>(key, value, null);
            size++;
            return null;
        }

        Entry<K, V> curr = head;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }
        if (curr != null) {
            V oldValue = curr.value;
            curr.value = value;
            return oldValue;
        } else {
            Entry<K, V> newHead = new Entry<K, V>(key, value, head);
            table[hash(key.hashCode())] = newHead;
            size++;
            return null;
        }
    }

    public synchronized Entry<K, V> remove(Object key) {
        Entry<K, V> curr = table[hash(key.hashCode())];
        Entry<K, V> prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
            size--;
            return curr;
        } else {
            return null;
        }
    }
}
