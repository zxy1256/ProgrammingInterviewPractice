package ch12linkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Ch12_1Test {
	@Test
	public void happyCase() {
		List<Integer> list = Arrays.asList(1,2,3,4);
		assertEquals(4, (int) Ch12_1.getNthLastElement(list, 0));
		assertEquals(2, (int) Ch12_1.getNthLastElement(list, 2));
		
		list = Arrays.asList(1);
		assertEquals(1, (int) Ch12_1.getNthLastElement(list, 0));
	}
	
	@Test
	public void nullCase() {
		List<Integer> list = Arrays.asList(1,2,3,4);
		assertNull(Ch12_1.getNthLastElement(list, 4));
		assertNull(Ch12_1.getNthLastElement(list, 10));
	}
	
	@Test
	public void testInvalidArgument() {
		List<Integer> list = Collections.EMPTY_LIST;
		assertNull(Ch12_1.getNthLastElement(list, 10));
	}
}
