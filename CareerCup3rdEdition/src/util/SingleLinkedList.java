package util;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class SingleLinkedList<T> extends AbstractSequentialList<T> implements List<T> {

	class Node<E> {
		public E mValue;
		public Node mNext;
		public Node(E value, Node next) {
			mValue = value;
			mNext = next;
		}
	}
	
	private Node<T> mHead;
	private Node<T> mEnd;
	int mSize;
	
	public SingleLinkedList() {
		mHead = null;
		mEnd = null;
		mSize = 0;
	}
	
	@Override
	public boolean add(T element) {
		mEnd.mNext = new Node<T>(element, null);
		mEnd = mEnd.mNext;
		if (mHead == null) {
			mHead = mEnd;
		}
		return true;
	}

	@Override
	public void add(int index, T element) throws IndexOutOfBoundsException {
		Node<T> currentNode = mHead;
		for (int i = 0; i < index; i++) {
			if (currentNode.mNext == null) {
				throw new IndexOutOfBoundsException();
			}
			currentNode = currentNode.mNext;
		}
		currentNode.mNext = new Node<T>(element, currentNode.mNext);
	}

	@Override
	public boolean addAll(Collection<T> collection) {
		return addAll(this.mSize, collection);
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ListOf 

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
