package ch2;

import java.util.List;

import org.junit.Test;

import careerCup3.ch2.Ch2_5;

import util.Matrix;
import util.RowMajorMatrix;
import static org.junit.Assert.assertTrue;

public class Ch2_5Test {
	@Test
	public void testFound() {
		Matrix mat = RowMajorMatrix.of(3, 4, 1.0, 2.0, 3.0, 4.0, 1.1, 2.1, 3.1, 4.1, 1.2, 2.2, 3.2, 4.2);
		List<Integer> indies = Ch2_5.search(mat, 2.1);
		assertTrue(indies.get(0) == 1 && indies.get(1) == 1);
	}
	
	@Test
	public void testNotFound() {
		Matrix mat = RowMajorMatrix.of(3, 4, 1.0, 2.0, 3.0, 4.0, 1.1, 2.1, 3.1, 4.1, 1.2, 2.2, 3.2, 4.2);
		List<Integer> indies = Ch2_5.search(mat, 2.3);
		assertTrue(indies.isEmpty());
	}
}
