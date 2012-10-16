package others;

import org.junit.Test;

public class CodedListTest {
    @Test
    public void test1() {
        int a1[] = { 1, 2, 3, 4 };
        test(a1);
        int a2[] = { 0, 3, 3, 4 };
        test(a2);
        int a3[] = { 0, 3, 0, 4 };
        test(a3);
        int a4[] = { 2, 3, 0, 4 };
        test(a4);
        int a5[] = { 2, 3, 0, 4, 0, 5, 0, 6, 1, 7 };
        test(a5);
    }

    private void test(int[] a) {
        CodedList cl = new CodedList(a);
        while (cl.hasNext()) {
            System.out.print(cl.getNext());
        }
        System.out.print("\n");
    }
}
