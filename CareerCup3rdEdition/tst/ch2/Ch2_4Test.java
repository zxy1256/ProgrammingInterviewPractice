package ch2;

import org.junit.Test;

public class Ch2_4Test {
	@Test
	public void rotateEvenSizeMatrix() {
        Matrix m = RowMajorMatrix.of(5, 5, 
        							 1.0, 2.0, 3.0, 4.0, 5.0, 
        							 6.0, 7.0, 8.0, 9.0, 10.0,
        							 11.0, 12.0, 13.0, 14.0, 15.0,
        							 16.0, 17.0, 18.0, 19.0, 20.0,
        							 21.0, 22.0, 23.0, 24.0, 25.0);
        System.out.println(m);
         
        Ch2_4.rotate_square_matrix_ccw(m);
        
        System.out.println(m);
	}
	
	@Test
	public void rotateOddSizeMatrix() {
		Matrix m = RowMajorMatrix.of(4, 4,
									 1.0, 1.0, 1.0, 1.0,
									 2.0, 2.0, 2.0, 2.0,
									 3.0, 3.0, 3.0, 3.0,
									 4.0, 4.0, 4.0, 4.0);
        System.out.println(m);
        
        Ch2_4.rotate_square_matrix_ccw(m);
        
        System.out.println(m);
	}
	
	@Test
	public void rotateOneElementMatrix() {
		Matrix m = RowMajorMatrix.of(1, 1, 1.0);
		System.out.println(m);

		Ch2_4.rotate_square_matrix_ccw(m);

		System.out.println(m);
	}
	
	@Test
	public void rotateFourElementsMatrix() {
		Matrix m = RowMajorMatrix.of(2, 2, 1.0, 1.0, 2.0, 2.0);
		System.out.println(m);

		Ch2_4.rotate_square_matrix_ccw(m);

		System.out.println(m);
	}
	
}
