// Akira Mizoguchi
// CS 143
// HW Core Topics: recursive backtracking
//
// This program will solve Sudoku and will show solving the Sudoku board by GUI.
import java.io.FileNotFoundException;

public class SudokuSolverEngine {
    public static void main(String[] args) throws FileNotFoundException {
        // Here I have called my class `MySudokuBoard` if you named your class
        // differently, modify the line below to use your own class name
        BoardGUI boardGUI=new BoardGUI(9);
        SudokuBoard3 board = new SudokuBoard3("src/very-fast-solve.sdk",boardGUI);
        System.out.println("Initial board");
        System.out.println(board);
        System.out.println();

        System.out.print("Solving board...");
        long start = System.currentTimeMillis();
        board.solve();
        long stop = System.currentTimeMillis();
        System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
        System.out.println();
        System.out.println(board);

    }
}
