import java.util.Scanner;

/*
 * Практика 1, вариант 1, задание 3
 * Создать приложение, выводящее n строк с переходом и без перехода на новую строку.
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

        String[] data = new String[n];

        System.out.printf("Enter %d strings by Enter:\n", n);
        int i = 0;
        do {
            data[i++] = scanner.nextLine();
        } while (i < n);

        System.out.println();

        // Without transition to a new line
        System.out.println("Without transition to a new line:");
        for (int ii = 0; ii < n; ii++){
            System.out.print(data[ii] + " ");
        }

        System.out.println();
        System.out.println();

        // With transition to a new line
        System.out.println("With transition to a new line:");
        for (int ii = 0; ii < n; ii++){
            System.out.println(data[ii]);
        }
    }
}