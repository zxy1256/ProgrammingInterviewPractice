package others;

import java.util.ArrayList;
import java.util.List;

/**
 * The N queen problem: http://en.wikipedia.org/wiki/Eight_queens_puzzle. This
 * is similar to the suduku problem.
 * 
 * @author sean
 * 
 */
public class NQueenProblem {
    public void solve(int n) {
        Board board = new Board(n);
        enumerate(board, 0);
    }

    private void enumerate(Board board, int i) {
        if (i == board.dimension) {
            System.out.print(board.toString());
            return;
        }

        for (int j = 0; j < board.dimension; j++) {
            board.set(i, j);
            if (board.isValid(i)) {
                enumerate(board, i + 1);
            }
        }
    }

    /*
     * One mistake I made is how to design this back-tracking class.
     */
    private class Board {
        int dimension;
        List<Integer> rows;

        Board(int n) {
            dimension = n;
            rows = new ArrayList<Integer>(n);
            for (int i = 0; i < dimension; i++) {
                rows.add(i, 0);
            }
        }

        /*
         * Return true if we can put a queen at i, j and does not violate the
         * constraints.
         */
        void set(int i, int j) {
            if (i < 0 || i >= dimension || j < 0 || j >= dimension) {
                throw new IllegalArgumentException();
            }

            rows.set(i, j);
        }

        boolean isValid(int level) {
            return noColumnConfliction(level) && noDialogConfliction(level);
        }

        boolean noColumnConfliction(int level) {
            List<Integer> columnMark = new ArrayList<Integer>(dimension);
            for (int j = 0; j < dimension; j++) {
                columnMark.add(j, 0);
            }
            for (int i = 0; i <= level; i++) {
                int j = rows.get(i);
                if (columnMark.get(j) != 0) {
                    return false;
                }
                columnMark.set(j, 1);
            }
            return true;
        }

        boolean noDialogConfliction(int level) {
            List<Integer> diagonalMark = new ArrayList<Integer>(
                    2 * dimension - 1);
            List<Integer> antiDiagonalMark = new ArrayList<Integer>(
                    2 * dimension - 1);

            for (int diff = 0; diff < 2 * dimension - 1; diff++) {
                diagonalMark.add(diff, 0);
                antiDiagonalMark.add(diff, 0);
            }

            for (int i = 0; i < level; i++) {
                int j = rows.get(i);
                if (diagonalMark.get(diagonalIndex(i, j)) != 0
                        || antiDiagonalMark.get(antiDiagonalIndex(i, j)) != 0) {
                    return false;
                }
                diagonalMark.set(diagonalIndex(i, j), 1);
                antiDiagonalMark.set(antiDiagonalIndex(i, j), 1);
            }
            return true;
        }

        int diagonalIndex(int i, int j) {
            int result = i - j + (dimension - 1);
            assert result > 0 && result < 2 * dimension - 1;
            return result;
        }

        int antiDiagonalIndex(int i, int j) {
            int result = i + j;
            assert result > 0 && result < 2 * dimension - 1;
            return result;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (j == rows.get(i)) {
                        builder.append("Q ");
                    } else {
                        builder.append("* ");
                    }
                }
                builder.append("\n");
            }
            return builder.toString();
        }
    }
}
