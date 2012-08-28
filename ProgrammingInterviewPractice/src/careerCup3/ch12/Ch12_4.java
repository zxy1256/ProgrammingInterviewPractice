package careerCup3.ch12;

import java.util.ArrayList;
import java.util.List;

import util.BFSIterator;
import util.BinarySearchTree;

public class Ch12_4 {
    public static <T extends Comparable<T>> List<List<T>> convertTreeToListByLayer(
            BinarySearchTree<T> tree) {
        List<List<T>> result = new ArrayList<List<T>>();
        BFSIterator<T> iterator = tree.bsfIterator();
        while (iterator.hasNext()) {
            T value = iterator.next();
            int level = iterator.getLevel();

            if (result.size() >= level) {
                List<T> currentLevelNodes = result.get(level - 1);
                currentLevelNodes.add(value);
            } else {
                List<T> currentLevelNodes = new ArrayList<T>();
                currentLevelNodes.add(value);
                result.add(level - 1, currentLevelNodes);
            }
        }
        return result;
    }
}
