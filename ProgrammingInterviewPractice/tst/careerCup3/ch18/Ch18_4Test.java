package careerCup3.ch18;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Ch18_4Test {
    @Test
    public void test() {
        String s = "This is a very very long story between apple, amazon, google and microsoft";
        List<String> patterns = Arrays.asList("very", "long", "apple",
                "microsoft", "This", "a");
        Ch18_4.findSubstring(s, patterns);
    }
}
