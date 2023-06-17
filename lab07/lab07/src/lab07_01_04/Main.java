package lab07_01_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is a sample text.";
        int wordLength = 4;
        String replacement = "******";

        String replacedText = replaceWordsOfLength(text, wordLength, replacement);
        System.out.println(replacedText);
    }

    public static String replaceWordsOfLength(String text, int wordLength, String replacement) {
        // Создаем регулярное выражение для слов заданной длины
        String regex = "\\b\\w{" + wordLength + "}\\b";

        // Компилируем регулярное выражение в шаблон
        Pattern pattern = Pattern.compile(regex);

        // Создаем объект Matcher для поиска совпадений в тексте
        Matcher matcher = pattern.matcher(text);

        // Заменяем найденные слова указанной подстрокой
        String replacedText = matcher.replaceAll(replacement);

        return replacedText;
    }
}
