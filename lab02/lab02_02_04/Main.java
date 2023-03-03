import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/*
 * Найти сумму элементов матрицы, расположенных между первым и
 * вторым положительными элементами каждой строки.
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

        int[][] data = new int[n][n];
        int[] sumData = new int[n];

        System.out.printf("Generated array %dx%d:\n", n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = getRandomInt(-n, n);
                System.out.printf("%3d ", data[i][j]);
            }
            System.out.println();
        }

        boolean sumFlag = false;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            sumFlag = false;
            for (int j = 0; j < n; j++) {
                if (data[i][j] < 0 && !sumFlag)
                    continue;
                if (data[i][j] > 0 && sumFlag)
                    break;
                if (data[i][j] > 0 && !sumFlag){
                    sumFlag = true;
                    continue;
                }
                sum += data[i][j];

            }
            sumData[i] = sum;
        }

        System.out.println();
        System.out.println("Result:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", data[i][j]);
            }
            System.out.printf(" --> %3d", sumData[i]);
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