package careerCup3.ch12;

import java.util.List;

import util.UnbalancedTreeSet;
import util.UnbalancedTreeMap.MapBFSIterator;



public class Ch12_4<T> {
	public <T> List<List<T>> convertTreeToListByLayer(UnbalancedTreeSet<T> tree) {
		List<List<T>> result = new List<List<T>>();
		MapBFSIterator iterator = tree.BSFIterator();
		int level = 0;
		while (iterator.hasNext()) {
			T value = iterator.next();
			List<T> currentLevelNodes =  result.get(iterator.getLevel());
			currentLevelNodes.add(value);
		}
	}
}
