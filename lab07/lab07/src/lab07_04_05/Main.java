package lab07_04_05;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "aabbbccdddd";

        // Создаем регулярное выражение для поиска одинаковых рядом стоящих символов
        Pattern pattern = Pattern.compile("(.)\\1+");

        // Создаем объект Matcher для нахождения соответствий регулярному выражению в тексте
        Matcher matcher = pattern.matcher(text);

        // Заменяем все найденные соответствия одним символом
        String result = matcher.replaceAll("$1");

        System.out.println(result);  // Выводит "abcd"
    }
}
