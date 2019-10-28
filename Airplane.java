import java.util.HashMap;
import java.util.Scanner;

public class Airplane {
    static String[][] seatingAssignment;
    static String[] map = new String[]{"A", "B", "C", "D"};

    public static void main(String[] args) {
        initMatrix();
        printMatrix();

        int row, col = 0;
        int maxSpaces = 35;
        Scanner scanner = new Scanner(System.in);

        while (maxSpaces != 0) {
            System.out.print("Please Enter a row number: ");
            row = scanner.nextInt();
            System.out.print("Please Enter a column number: ");
            col = scanner.nextInt();

            if (seatingAssignment[row - 1][col - 1].equals("X")) {
                System.err.print("Cannot mark already assigned seat. \n");
            } else {
                seatingAssignment[row - 1][col - 1] = "X";
                maxSpaces--;
            }
            printMatrix();
        }
    }

    private static void initMatrix() {
        seatingAssignment = new String[7][5];

        for(int i = 0; i < seatingAssignment.length; i++) {
            for(int j = 0; j < seatingAssignment[i].length; j++) {
                if(j == 0) seatingAssignment[i][j] = Integer.toString(i + 1);
                else seatingAssignment[i][j] = map[j - 1];
            }
        }
    }

    private static void printMatrix() {
        for(int i = 0; i < seatingAssignment.length; i++) {
            for(int j = 0; j < seatingAssignment[i].length; j++) {
                System.out.print(seatingAssignment[i][j] + " ");
            }
            System.out.println();
        }
    }

}

