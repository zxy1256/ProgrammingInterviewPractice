package ch12linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import careerCup3.ch12.Ch12_2;

public class Ch12_2Test {
	@Test
	public void testNoDuplicateElement() {
		Ch12_2.removeDuplicateElement(Arrays.asList(1,2,3,4,5));
	}
	
	@Test
	public void testIdenticalElement() {
		List l = new LinkedList();
		l.addAll(Arrays.asList(1,1,1));
		Ch12_2.removeDuplicateElement(l);
	}
}
