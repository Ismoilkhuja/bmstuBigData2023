import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/*
 * Ввести n слов с консоли. Найти слово, в котором число различных символов минимально.
 * Если таких слов несколько, найти первое из них.
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
        int[] numDifChars = new int[n];

        System.out.printf("Enter %d words by Enter:\n", n);
        int i = 0;
        do {
            data[i++] = scanner.next();
        } while (i < n);

        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int k = 1; k < data[j].length(); k++) {
                int match = 0;
                for (int l = 0; l < k; l++) {
                    if (data[j].charAt(k) == data[j].charAt(l))
                        match = 1;
                }
                if (match == 0)
                    count++;
            }
            numDifChars[j] = count;
        }

        int index = 0;
        int min = numDifChars[index];

        for (int j = 1; j < numDifChars.length; j++){
            if (numDifChars[j] < min){
                min = numDifChars[j];
                index = j;
            }
        }

        System.out.println();
        System.out.println("Result:");
        System.out.print(data[index]);
        System.out.println();

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
}