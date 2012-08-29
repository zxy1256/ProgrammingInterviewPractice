package careerCup3.ch18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ch18_2 {
    public static void sortByAnagram(final List<String> list) {
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                String sorted1 = convert(s1);
                String sorted2 = convert(s2);
                return sorted1.compareToIgnoreCase(sorted2);
            }

            private String convert(String s) {
                char[] ca = s.toLowerCase().toCharArray();
                Arrays.sort(ca);
                return String.valueOf(ca).trim();
            }
        });
    }
}
