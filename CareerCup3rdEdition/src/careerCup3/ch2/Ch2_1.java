package careerCup3.ch2;
import java.util.List;
import java.util.ArrayList;

import util.RowMajorMatrix;

/**
 * Hint: When scan the matrix, do not record the (i,j) together, 
 * store the row and column index separately
 * @author sean
 *
 */
public class Ch2_1 {
    public void resetCrossIfZero(RowMajorMatrix m) {
        List<Integer> size = m.getSize();
        int row_limit = size.get(0);
        int column_limit = size.get(1);
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> columns = new ArrayList<Integer>();

        for (int i = 0; i < row_limit; i++) {
            for (int j = 0; j < column_limit; j++) {
                if (m.get(i,j) == 0.0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        
        for (int i = 0; i < rows.size(); i++) {
            m.resetCross(rows.get(i), columns.get(i));
        }
    }
}


