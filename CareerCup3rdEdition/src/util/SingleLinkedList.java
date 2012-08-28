package util;

import java.util.Iterator;

/**
 * Single linked list
 * 
 * @author zhaxinyu
 * 
 * @param <T>
 */
public class SingleLinkedList<T> {

    public static class Node<E> {
        public E mValue;
        public Node<E> mNext;

        public Node(E value, Node<E> next) {
            mValue = value;
            mNext = next;
        }

        public Node<E> next() {
            return mNext;
        }

        public E value() {
            return mValue;
        }
    }

    private Node<T> mHead;
    private Node<T> mEnd;
    private int mSize;

    public SingleLinkedList() {
        mHead = null;
        mEnd = null;
        mSize = 0;
    }

    public boolean add(T element) {
        if (mEnd == null) {
            mEnd = new Node<T>(element, null);
            mHead = mEnd;
            mSize++;
        } else {
            mEnd.mNext = new Node<T>(element, null);
            mEnd = mEnd.mNext;
            mSize++;
        }
        return true;
    }

    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = mHead;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.mNext;
        }
        currentNode.mValue = element;
    }

    public int size() {
        return mSize;
    }

    public Iterator<T> iterator() {
        return null;
    }

    private class SingleListIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }

    }
}
