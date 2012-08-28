package careerCup3.ch2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import careerCup3.ch2.Ch2_3;
public class Ch2_3Test {
	@Test
	public void test() {
		assertEquals(5, Ch2_3.maxSubListSum(Arrays.asList(2, -8, 3, -2, 4, -10)));
	}

	@Test
	public void testIncreasingArray() {
		assertEquals(10, Ch2_3.maxSubListSum(Arrays.asList(1,2,3,4)));
	}
	
	@Test
	public void testSingleElementArray() {
		assertEquals(1, Ch2_3.maxSubListSum(Arrays.asList(1)));
	}
	
	@Test
	public void testNegativeArray() {
		assertEquals(0, Ch2_3.maxSubListSum(Arrays.asList(-1,-2,-3)));
	}
	
	@Test
	public void test2() {
		assertEquals(10, Ch2_3.maxSubListSum(Arrays.asList(-1,-2,-3,10)));
	}
	
	@Test
	public void testEmptyArray() {
		assertEquals(0, Ch2_3.maxSubListSum(new ArrayList<Integer>()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		Ch2_3.maxSubListSum(null);
	}
}
