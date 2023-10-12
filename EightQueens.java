import java.util.ArrayList;

public class EightQueens {
    public static final int GRID_SIZE = 8;

    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) { // Found a valid placement
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col; // Place a queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            // Check if rows have a queen in the same column
            if (column1 == column2) {
                return false;
            }

            // Check diagonals: if the distance between columns equals the distance between rows, they're in the same diagonal
            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;

            if (columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EightQueens solver = new EightQueens();
        ArrayList<Integer[]> results = new ArrayList<>();
        Integer[] columns = new Integer[GRID_SIZE];

        solver.placeQueens(0, columns, results);

        System.out.println("All solutions for placing eight queens on an 8x8 chessboard:");

        for (Integer[] result : results) {
            printBoard(result);
            System.out.println();
        }
    }

    static void printBoard(Integer[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (columns[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}


//javac EightQueens.java
// java EightQueens
