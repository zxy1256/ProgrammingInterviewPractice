package Ch2;

import org.junit.Test;

public class Ch2_2Test {

	@Test
	public void testNoDuplicate() {
		test("abcd");
	}
	
	@Test
	public void testConsecutiveDuplicate() {
		test("aaaa");
	}
	
	@Test
	public void testSomeDuplicate() {
		test("acbdabcd");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		test(null);
	}

	@Test
	public void testEmptyString() {
		test("");
	}

	private void test(String s) {
		System.out.println("Input: "+ s + "\n");
		System.out.println("Output: " + Ch2_2.dedupString(s) + "\n");
	}
}
