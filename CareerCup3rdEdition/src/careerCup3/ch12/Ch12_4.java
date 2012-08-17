package careerCup3.ch12;

import java.util.ArrayList;
import java.util.List;

import util.BFSIterator;
import util.BinarySearchTree;



public class Ch12_4 {
	public <T extends Comparable<T>> List<List<T>> convertTreeToListByLayer(BinarySearchTree<T> tree) {
		List<List<T>> result = new ArrayList<List<T>>();
		BFSIterator<T> iterator = tree.bsfIterator();
		while (iterator.hasNext()) {
			T value = iterator.next();
			List<T> currentLevelNodes =  result.get(iterator.getLevel());
			currentLevelNodes.add(value);
		}
		return result;
	}
}
