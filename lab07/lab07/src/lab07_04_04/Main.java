package lab07_04_04;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is an example text with some substrings to exclude. We want to remove the maximum length substring starting with 's' and ending with 'e'. Let's see the result.";

        // Заданные символы для начала и конца подстроки
        char startChar = 's';
        char endChar = 'e';

        // Определяем регулярное выражение для поиска подстроки максимальной длины
        String regex = String.format("%s.*?%s", startChar, endChar);


        // Создаем объект Pattern
        Pattern pattern = Pattern.compile(regex);

        // Создаем объект Matcher
        Matcher matcher = pattern.matcher(text);

        String maxSubstring = "";

        while (matcher.find()) {
            //debug
            System.out.printf("%d: %s\n", matcher.group().length(), matcher.group());

            if (maxSubstring.length() < matcher.group().length()){
                maxSubstring = matcher.group();
            }
        }

        String result = text.replace(maxSubstring, "");

        // Выводим начальный текст
        System.out.println(text);

        // Выводим измененный текст
        System.out.println(result);
    }
}
