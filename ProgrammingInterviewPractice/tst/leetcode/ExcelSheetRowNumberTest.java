package leetcode;

import java.util.List;

import org.junit.Test;

public class ExcelSheetRowNumberTest {
    @Test
    public void testZero() {
        ExcelSheetRowNumber problem = new ExcelSheetRowNumber();
        int[] input = { 0, 1, 2, 26, 27, 51, 676, 702 };
        List<String> result = problem.solve(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + "-->" + result.get(i));
        }
        System.out.println(Character.forDigit('b', 10));
    }
}
