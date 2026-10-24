import java.util.Scanner;

public class Airplane {
    static String[][] seatingAssignment;
    static String[] map = new String[]{"A", "B", "C", "D"};

    public static void main(String[] args) {
        initMatrix();
        printMatrix();

        int row, col = 0;
        // FIX: 7 rows x 4 seat letters (A-D) = 28 real seats, not 35.
        // Column 0 of the array holds the row number, not a seat.
        int maxSpaces = 28;
        Scanner scanner = new Scanner(System.in);

        while (maxSpaces != 0) {
            System.out.print("Please Enter a row number: ");
            row = scanner.nextInt();
            System.out.print("Please Enter a column number: ");
            col = scanner.nextInt();

            // FIX: bounds check. Previously any row/col outside 1-7 / 1-4
            // threw ArrayIndexOutOfBoundsException, and col 1 mapped to
            // index 0 (the row label) and overwrote it with "X".
            // Seats are at index col (1..4), labels at index 0.
            if (row < 1 || row > 7 || col < 1 || col > 4) {
                System.err.print("Row must be 1-7 and column 1-4.\n");
                printMatrix();
                continue;
            }
            if (seatingAssignment[row - 1][col].equals("X")) {
                System.err.print("Cannot mark already assigned seat. \n");
            } else {
                seatingAssignment[row - 1][col] = "X";
                maxSpaces--;
            }
            printMatrix();
        }
    }

    private static void initMatrix() {
        seatingAssignment = new String[7][5];

        for (int i = 0; i < seatingAssignment.length; i++) {
            for (int j = 0; j < seatingAssignment[i].length; j++) {
                if (j == 0) seatingAssignment[i][j] = Integer.toString(i + 1);
                else seatingAssignment[i][j] = map[j - 1];
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < seatingAssignment.length; i++) {
            for (int j = 0; j < seatingAssignment[i].length; j++) {
                System.out.print(seatingAssignment[i][j] + " ");
            }
            System.out.println();
        }
    }

}
