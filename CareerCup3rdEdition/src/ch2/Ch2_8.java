package ch2;

import static java.lang.Math.min;

public class Ch2_8 {
	/**
	 * Use dynamic programming	
	 * @param m
	 * @return A three element list
	 */
	public static Result maxSingleColorMatrix(Matrix m) {
		// Scan the matrix 3 times.
		// 1. Find the maximum length of continuous black pixel in a row towards left
		// 2. Find the maximum length of continuous black pixel in a column upwards
		// 3. Find the max square with (i,j) as the lower right point
		
		// maxBlackRow(i,j) is the length of black row with (i,j) as the right end
		Matrix maxBlackRow = new RowMajorMatrix(m.getRowSize(), m.getColumnSize(), 0.0);
		for (int i = 0; i < m.getRowSize(); i++) {
			if (m.get(i, 0) == 1) {
				maxBlackRow.set(i, 0, 1.0);
			}
			for (int j = 1; j < m.getColumnSize(); j++) {
				if (m.get(i, j) == 1) {
					maxBlackRow.set(i, j, maxBlackRow.get(i, j-1)+1);
				}
			}
		}
		
		// maxBlackCol is the length of black column with (i,j) as the lowest point
		Matrix maxBlackCol = new RowMajorMatrix(m.getRowSize(), m.getColumnSize(), 0.0);
		for (int j = 0; j < m.getColumnSize(); j++) {
			if (m.get(0, j) == 1) {
				maxBlackCol.set(0, j, 1.0);
			}
			for (int i = 1; i < m.getRowSize(); i++) {
				if (m.get(i, j) == 1) {
					maxBlackCol.set(i, j, maxBlackCol.get(i-1, j)+1);
				}
			}
		}
		
		// maxSquare is the size of black square with (i,j) as the lower left point.
		int maxSquareSize = 0;
		int maxSquareI = 0;
		int maxSquareJ = 0;
		Matrix maxSquare = new RowMajorMatrix(m.getRowSize(), m.getColumnSize(), 0.0);
		for (int j = 0; j < m.getColumnSize(); j++) {
			if (m.get(0, j) == 1) {
				maxSquare.set(0, j, 1.0);
				maxSquareSize = 1;
				maxSquareI = 0;
				maxSquareJ = j;
			}
		}
		for (int i = 0; i < m.getRowSize(); i++) {
			if (m.get(i, 0) == 1) {
				maxSquare.set(i, 0, 1.0);
				maxSquareSize = 1;
				maxSquareI = i;
				maxSquareJ = 0;
			}
		}
		for (int i = 1; i < m.getRowSize(); i++) {
			for (int j = 1; j < m.getColumnSize(); j++) {
				final double squareSize = min(min(maxSquare.get(i-1, j-1)+1, maxBlackCol.get(i, j)), maxBlackRow.get(i, j));
				maxSquare.set(i, j, squareSize);
				if (squareSize > maxSquareSize) {
					maxSquareSize = (int) squareSize;
					maxSquareI = i;
					maxSquareJ = j;
				}
			}
		}
		return new Result(maxSquareI, maxSquareJ, maxSquareSize);
	}
	
	static class Result {
		int i;
		int j;
		int size;
		
		public Result(int i, int j, int size) {
			this.i = i;
			this.j = j;
			this.size = size;
		}
		
		@Override
		public String toString() {
			return "i=" + i + ", j=" + j + ", size="+size; 
		}
	}
}
	