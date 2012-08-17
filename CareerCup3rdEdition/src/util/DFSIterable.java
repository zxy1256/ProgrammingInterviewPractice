package util;

public interface DFSIterable<T> {
	PreOrderIterator<T> preOrderIterator();
	InOrderIterator<T> inOrderIterator();
	PostOrderIterator<T> postOrderIterator();
}
