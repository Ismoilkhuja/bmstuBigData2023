package lab07_02_04;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is a sample text. Another sentence. And one more.";

        // Разделение текста на предложения
        String[] sentences = text.split("[.?!]");

        for (String sentence : sentences) {
            // Удаление лишних пробелов в начале и конце предложения
            sentence = sentence.trim();

            // Подсчет гласных и согласных букв в предложении
            int vowelsCount = countVowels(sentence);
            int consonantsCount = countConsonants(sentence);

            // Вывод результата для каждого предложения
            System.out.println("Sentence: " + sentence);
            System.out.println("Vowels count: " + vowelsCount);
            System.out.println("Consonants count: " + consonantsCount);
            System.out.println();
        }
    }

    public static int countVowels(String sentence) {
        // Создаем регулярное выражение для поиска гласных букв
        Pattern pattern = Pattern.compile("[aeiouAEIOU]");
        Matcher matcher = pattern.matcher(sentence);

        // Подсчитываем количество совпадений
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static int countConsonants(String sentence) {
        // Создаем регулярное выражение для поиска согласных букв
        Pattern pattern = Pattern.compile("[^aeiouAEIOU\\s\\W\\d]");
        Matcher matcher = pattern.matcher(sentence);

        // Подсчитываем количество совпадений
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
