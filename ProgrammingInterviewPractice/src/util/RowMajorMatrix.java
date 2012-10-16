package util;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class RowMajorMatrix implements Matrix {
    private final Vector<Vector<Double>> matrix;
    private final int row_num;
    private final int column_num;

    public RowMajorMatrix(final int row_num, final int column_num) {
        this(row_num, column_num, 0.0);
    }

    public RowMajorMatrix(final int row_num, final int column_num,
            final double init_value) {
        this.row_num = row_num;
        this.column_num = column_num;
        matrix = new Vector<Vector<Double>>(row_num);
        for (int i = 0; i < row_num; i++) {
            Vector<Double> row = new Vector<Double>(column_num);
            for (int j = 0; j < column_num; j++) {
                row.add(init_value);
            }
            matrix.add(row);
        }
    }

    @Override
    public Double get(final int i, final int j) {
        Vector<Double> row = matrix.get(i);
        return row.get(j);
    }

    @Override
    public List<Integer> getSize() {
        return Arrays.asList(row_num, column_num);
    }

    @Override
    public void set(final int i, final int j, final double value) {
        matrix.get(i).set(j, value);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                stringBuilder.append(get(i, j)).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void resetCross(final int row, final int column) {
        for (int j = 0; j < column_num; j++) {
            set(row, j, 0.0);
        }
        for (int i = 0; i < row_num; i++) {
            set(i, column, 0.0);
        }
    }

    @Override
    public int getRowSize() {
        return row_num;
    }

    @Override
    public int getColumnSize() {
        return column_num;
    }

    public static Matrix of(int m, int n, Double... values) {
        if (values.length != m * n) {
            throw new IllegalArgumentException();
        }
        Matrix mat = new RowMajorMatrix(m, n, 0.0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat.set(i, j, values[i * n + j]);
            }
        }
        return mat;
    }

}
