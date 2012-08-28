package careerCup3.ch2;

import util.Matrix;


public class Ch2_4 {
	/**
	 * Assume Matrix is a square matrix
	 * @param m
	 */
	public static void rotate_square_matrix_ccw(Matrix m) {
		if (m == null || m.getRowSize() != m.getColumnSize()) {
			throw new IllegalArgumentException(); 
		}
		
		// Do a four-way swap
		int size = m.getRowSize();
		// Swap from outside towards inside. 
		// "level = 0" means the the most outside row and column.
		// If size = 2n, there are n levels to swap
		// If size = 2n+1, there are n levels to swap
		for (int level = 0; level < size/2; level++) {
			int left = level;
			int top = level;
			int right = size - 1 - level;
			int bottom = size - 1 - level;
			for (int offset = 0; offset < right - left; offset++) {
				Double temp = m.get(top+offset, left);
				m.set(top + offset, left, m.get(top, right - offset));
				m.set(top, right - offset, m.get(bottom - offset, right));
				m.set(bottom - offset, right, m.get(bottom, left + offset));
				m.set(bottom, left + offset, temp);
			}
		}
	}
}
