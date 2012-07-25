package ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch2_5 {
	/**
	 * 
	 * @param mat
	 * @param value
	 * @return A list of two int for the index of VALUE with in matrix MAT. Empty list if VALUE is not found in MAT.
	 */
	public static List<Integer> search(Matrix mat, double value) {
		if (!(isRowSorted(mat) && isColumnSorted(mat))) {
			throw new IllegalArgumentException();
		}
		
		int i = 0;
		int j = mat.getColumnSize()-1;
		while (i < mat.getRowSize() && j > 0) {
			if ( value < mat.get(i, j) ) {
				j--;
			} else if ( value > mat.get(i,j) ){
				i++;
			} else {
				return Arrays.asList(i, j);
			}
		}
		return new ArrayList<Integer>();
	}
	
	private static boolean isRowSorted(Matrix mat) {
		for (int i = 0; i<mat.getRowSize(); i++) {
			for (int j=1; j<mat.getColumnSize(); j++) {
				if (mat.get(i, j) < mat.get(i,j-1)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isColumnSorted(Matrix mat) {
		for (int j = 0; j<mat.getColumnSize(); j++) {
			for (int i=1; i<mat.getRowSize(); i++) {
				if (mat.get(i, j) < mat.get(i-1, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
