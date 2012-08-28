package careerCup3.ch12;

import java.util.List;

import org.junit.Test;

import util.BinarySearchTree;
import careerCup3.ch12.Ch12_4;

public class Ch12_4Test {
    @Test
    public void test() {
        BinarySearchTree<Integer> mBalancedTree = BinarySearchTree.of(5, 2, 7,
                1, 3, 6, 8);
        List<List<Integer>> result = Ch12_4
                .convertTreeToListByLayer(mBalancedTree);
        for (List<Integer> level : result) {
            for (Integer node : level) {
                System.out.print(node + ", ");
            }
            System.out.print("\n");
        }
    }
}
