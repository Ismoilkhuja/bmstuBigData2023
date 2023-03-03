import java.util.Scanner;

/*
 * Практика 1, вариант 2, задание 1
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
 * Четные и нечетные числа.
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

        int[] data = new int[n];

        int[] evenData = new int[n];
        int evenCount = 0;

        int[] oddData = new int[n];
        int oddCount = 0;

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

        // filling odd and even arrays
        for (int ii = 0; ii < n; ii++){
            if (data[ii]%2 == 0)
                evenData[evenCount++] = data[ii];
            else
                oddData[oddCount++] = data[ii];
        }

        // output even data
        System.out.println("Even numbers:");
        for (int ii = 0; ii < evenCount; ii++)
            System.out.printf("%d ", evenData[ii]);

        System.out.println();

        // output odd data
        System.out.println("Odd numbers:");
        for (int ii = 0; ii < oddCount; ii++)
            System.out.printf("%d ", oddData[ii]);

    }
}