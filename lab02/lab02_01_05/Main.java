import java.util.Date;
import java.util.Scanner;

/*
 * Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского алфавита,
 * а среди них – количество слов с равным числом гласных и согласных букв.
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

        int countEn = 0;
        int countEqual = 0;

        for (int j = 0; j < n; j++) {
            int match = 1;
            for (int k = 0; k < data[j].length(); k++) {
                char tmp = data[j].charAt(k);
                if ((tmp < 65 || tmp > 90) && (tmp < 97 || tmp > 122))
                    match = 0;
            }
            if (match == 1){
                countEn++;
                int countVowels = 0;
                int countCons = 0;
                String str = data[j].toLowerCase();
                for (int k = 0; k < data[j].length(); k++) {
                    if (isVowel(str.charAt(k)))
                        countVowels++;
                    else
                        countCons++;
                }
                if (countVowels == countCons)
                    countEqual++;
            }
        }
        System.out.println();
        System.out.println("The number of words containing only latin characters:");
        System.out.println(countEn);
        System.out.println();
        System.out.println("The number of words with an equal number of vowels and consonants:");
        System.out.println(countEqual);

        printSignature();
    }

    public static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
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