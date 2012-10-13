import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.lang.Character;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class PhonenumberToStringConverter {
    private Map<Character, List<Character>> mDigitToCharMap;
    private Set<String> mDict;

    public PhonenumberToStringConverter(Set<String> dict) {
        mDigitToCharMap = new HashMap();
        mDigitToCharMap.put('2', Arrays.asList('a', 'b', 'c'));
        mDigitToCharMap.put('3', Arrays.asList('d', 'e', 'f'));
        mDigitToCharMap.put('4', Arrays.asList('g', 'h', 'i'));
        mDigitToCharMap.put('5', Arrays.asList('j', 'k', 'l'));
        mDigitToCharMap.put('6', Arrays.asList('m', 'n', 'o'));
        mDigitToCharMap.put('7', Arrays.asList('p', 'q', 'r','s'));
        mDigitToCharMap.put('8', Arrays.asList('t', 'u', 'v'));
        mDigitToCharMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        mDict = dict;
    }

    public static void main(String[] args) throws IOException {
        Set<String> dic = new HashSet<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(args[0])));
            int dicSize = 0;
            if (scanner.hasNext()) {
                dicSize = scanner.nextInt();
            }
            for (int i = 0; i< dicSize; i++) {
                String word = scanner.next();
                dic.add(word);
                System.out.println("Added " + word);
            }

            PhonenumberToStringConverter converter = new PhonenumberToStringConverter(dic);

            while (scanner.hasNext()) {
                System.out.println(converter.convert(scanner.next()));
            } 
        } catch (final Exception e) {
            System.out.println(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

    public String convert(String phonenumber) {
        System.out.println("Converting " + phonenumber);
        return convert(phonenumber.toCharArray(), 0, "");
    }
    /*
     *
     */
    private String convert(char[] phonenumber, int beginIndex, String prefix) {
        if (beginIndex == phonenumber.length) {
            System.out.println("Checking " + prefix);
            return mDict.contains(prefix) ? prefix : "";
        }
       
        Character currentChar = Character.valueOf(phonenumber[beginIndex]);

        if (!mDigitToCharMap.containsKey(currentChar)) {
            throw new IllegalArgumentException("Invalid digit");
        }
        
        for (Character c : mDigitToCharMap.get(currentChar)) {
            String result = convert(phonenumber, beginIndex+1, prefix + c); 
            if ( result != null && !result.isEmpty()) {
                return result;
            }
        }
        return "";
    }
}  

