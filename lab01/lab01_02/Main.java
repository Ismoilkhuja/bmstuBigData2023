/*
 * Практика #1, часть 2
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
 * элементы, которые равны полусумме соседних элементов.
 */
import java.util.Scanner;

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

        int[] data = new int[n];

        // if user entered more than 1 number in previous input, switch to the nexl line
        scanner.nextLine();

        System.out.printf("Enter %d integers by space:\n", n);
        int i = 0;
        do {
                if (scanner.hasNextInt())
                    data[i++] = scanner.nextInt();
                else
                    scanner.next();
        } while (i < n);

        // output data
        System.out.println("Your output:");
        for (int j = 0; j < n; j++) {
            System.out.printf("%d ", data[j]);
        }
        System.out.println();
        System.out.println("Elements that are equal to half the sum of adjacent elements:");
        // first and last elements don't have one adjacent element, so omit them
        for (i = 1; i < n -1; i++) {
            double tmp = (data[i-1] + data[i+1]) / 2d;
            if (tmp == (double)data[i])
                System.out.printf("%d ",data[i]);
        }
    }
}