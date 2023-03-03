import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/*
 * Транспонировать квадратную матрицу.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter count N:");
        do {
            if (scanner.hasNextInt())
                n = scanner.nextInt();
            else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        } while (n == 0);

        // if user entered more than 1 number in previous input, switch to the nexl line
        scanner.nextLine();

        int[][] matrix = new int[n][n];
        int[][] matrixTransposed = new int[n][n];

        System.out.printf("Generated matrix %dx%d:\n", n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = getRandomInt(-n, n);
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixTransposed[i][j] = matrix[j][i];
            }
        }
        System.out.println();
        System.out.println("Transposed matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", matrixTransposed[i][j]);
            }
            System.out.println();
        }
            printSignature();
    }

    public static void printSignature(){
        String author = "Nuriddinov";
        String receivedDate = "17/02/2023 15:39";
        Date nowDate = new Date();
        System.out.println();
        System.out.println("Author: " + author);
        System.out.println("Date of reception: " + receivedDate);
        System.out.println("Due date: " + nowDate.toString());

    }

    public static int getRandomInt(int min, int max){
        Random rand = new Random();
        return (rand.nextInt(max - min) + min);
    }
}