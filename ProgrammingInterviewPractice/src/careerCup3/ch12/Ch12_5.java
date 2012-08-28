package careerCup3.ch12;

import util.SingleLinkedList;

public class Ch12_5 {
    public static <E> void delete(SingleLinkedList<E> l,
            SingleLinkedList.Node<E> node) {
        if (node.next() == null) {
            throw new IllegalArgumentException(
                    "Given node is at the end of the list");
        } else {
            node.mNext = node.mNext.mNext;
        }
    }
}
