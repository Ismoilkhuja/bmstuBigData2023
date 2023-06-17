package lab07_03_04;
import java.text.BreakIterator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "What day of the week is today? What are you going to do on the weekend. What is your favorite dish?";

        int wordLength = 4; // Заданная длина слова

        Set<String> words = findWordsByLength(text, wordLength);

        System.out.println("Words of length " + wordLength + " in question sentences (without duplicates):");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static Set<String> findWordsByLength(String text, int length) {

        // Создаем регулярное выражение для для разделения предложений
        String regex = "([^.!?]+[?])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Создаем регулярное выражение для поиска слов заданной длины
        String regexWord = "\\b\\w{" + length + "}\\b";
        Pattern patternWord = Pattern.compile(regexWord, Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS);

        // Создаем множество для хранения найденных слов
        Set<String> words = new HashSet<>();

        while (matcher.find()){
            // for debug
            // System.out.println(matcher.group());

            Matcher matcherWord = patternWord.matcher(matcher.group());
            // Добавляем слова в множество
            while (matcherWord.find()) {
                words.add(matcherWord.group());
            }
        }

        return words;
    }
}
