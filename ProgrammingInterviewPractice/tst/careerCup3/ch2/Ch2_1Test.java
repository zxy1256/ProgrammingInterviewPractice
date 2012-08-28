package careerCup3.ch2;

import org.junit.Test;

import careerCup3.ch2.Ch2_1;

import util.RowMajorMatrix;



public class Ch2_1Test {
	@Test
    public void testOneZeroElement() {		
        RowMajorMatrix m = new RowMajorMatrix(5, 3, 1.0);
        m.set(1,1,0.0);
        System.out.println(m);
        System.out.println("===============\n");
        Ch2_1 ch2_1 = new Ch2_1();
        ch2_1.resetCrossIfZero(m);
        System.out.println(m);
    }
}
