package leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SnapperChain {
    public boolean solve(int n, int k) {
        for (int i = 0; i < n; i++) {
            int shifted = k >> i;
            if (shifted % 2 == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        SnapperChain problem = new SnapperChain();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(args[0])));

            int numOfInput = Integer.parseInt(scanner.next());
            
            for (int i = 0; i < numOfInput; i++) {
                int n = Integer.parseInt(scanner.next());
                int k = Integer.parseInt(scanner.next());
                String result = problem.solve(n,k)? "ON" : "OFF";
                System.out.println("Case #" + (i+1) + ": " + result);
            }
        } finally {
            if (scanner!= null) {
                scanner.close();
            }
        }
        
    }
}
