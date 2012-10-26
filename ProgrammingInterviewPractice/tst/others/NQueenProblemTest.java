package others;

import org.junit.Test;

public class NQueenProblemTest {
    @Test
    public void testEightQueens() {
        NQueenProblem problem = new NQueenProblem();
        problem.solve(12);
    }
}
