package lab07_01_05;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is a sample text.";
        int k = 5;
        String substring = "INSERTED";

        String modifiedText = insertSubstring(text, k, substring);
        System.out.println(modifiedText);
    }

    public static String insertSubstring(String text, int k, String substring) {
        if (k < 0 || k >= text.length()) {
            // Проверка на допустимое значение k
            System.out.println("Invalid value of k.");
            return text;
        }

        // Создаем регулярное выражение для вставки подстроки после k-го символа
        String regex = "(?<=^.{" + k + "})";

        // Компилируем регулярное выражение в шаблон
        Pattern pattern = Pattern.compile(regex);

        // Создаем объект Matcher для поиска совпадений в тексте
        Matcher matcher = pattern.matcher(text);

        // Вставляем подстроку после k-го символа
        String modifiedText = matcher.replaceFirst(substring);

        return modifiedText;
    }
}
