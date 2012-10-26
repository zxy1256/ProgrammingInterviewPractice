package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * http://www.leetcode.com/2010/10/amazon-bar-raiser-interview-question.html
 * 
 * Tag: recursion, base conversion
 */

public class ExcelSheetRowNumber {
    private static int char_a_in_digit = 'a';

    public List<String> solve(int[] s2) {
        List<String> result = new LinkedList<String>();
        for (int i : s2) {
            result.add(convertIntToRowNumber(i));
        }
        return result;
    }

    private String convertIntToRowNumber(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Must be positive");
        }

        int divider = 26;
        while (i / divider > 26) {
            divider = divider * 26;
        }

        StringBuilder strBuilder = new StringBuilder();

        int dividend = i;
        while (dividend >= 26) {
            strBuilder.append(digitToCharHigh(dividend / divider));
            dividend = dividend % divider;
            divider = divider / 26;
        }

        strBuilder.append(digitToCharLow(dividend));
        return strBuilder.toString();
    }

    private char digitToCharLow(int d) {
        assert d >= 0 && d <= 25;
        return (char) (char_a_in_digit + d);
    }

    private char digitToCharHigh(int d) {
        assert d >= 1 && d <= 26;
        return (char) (char_a_in_digit + d - 1);
    }
}
