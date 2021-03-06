package careerCup3.ch2;

/**
 * Example:
 * Input: 1 2 5 2 3 -1 3
 * Output: 1 2 5 3 -1
 * @author sean
 * 
 * HINT: There is only 256 characters, so use a "Hash map require a fixed size of memory.
 */
public class Ch2_2 {
	static public String dedupString(String s) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		char[] charArray = s.toCharArray();
		char[] charTable = new char[256];
		for (int i = 0; i < charTable.length; i++) {
			charTable[i] = 0;
		}
		
		int read = 0;
		int write = 0;
		while (read < charArray.length) {
			charArray[write] = charArray[read];
			if (charTable[charArray[read]] == 0) {
				charTable[charArray[read]] = 1;
				write++;
			}
			read++;
		}
		return new String(charArray, 0, write);
	}
}
