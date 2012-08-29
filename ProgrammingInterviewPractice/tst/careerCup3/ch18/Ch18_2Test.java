package careerCup3.ch18;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import util.ListUtil;

public class Ch18_2Test {
    @Test
    public void testHappyCase() {
        final List<String> list = Arrays.asList("army", "mary", "George Bush",
                "He bugs Gore", "test");
        Ch18_2.sortByAnagram(list);
        ListUtil.print(list);
    }
}
