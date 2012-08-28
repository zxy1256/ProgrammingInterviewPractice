package careerCup3.ch2;

import org.junit.Test;

import careerCup3.ch2.Ch2_8;

import util.Matrix;
import util.RowMajorMatrix;

public class Ch2_8Test {
	@Test
	public void Test1 () {
		Matrix m = RowMajorMatrix.of(4, 4, 
									 0.0, 0.0, 0.0, 0.0,
									 0.0, 1.0, 1.0, 0.0,
									 0.0, 1.0, 1.0, 0.0,
									 0.0, 0.0, 1.0, 0.0);
		Ch2_8.Result result = Ch2_8.maxSingleColorMatrix(m);
		System.out.println(result);
	}
}
