package lab07_03_05;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is the first sentence. And here is the second one. Finally, we have the third sentence.";

        // Определяем регулярное выражение для предложений
        String regex = "(?<=\\.\\s|^)[^.!?]+(?=[.!?])";

        // Создаем объект Pattern
        Pattern pattern = Pattern.compile(regex);

        // Создаем объект Matcher
        Matcher matcher = pattern.matcher(text);

        // Заменяем первое слово с последним в каждом предложении
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String sentence = matcher.group();
            String[] words = sentence.split("\\s");

            if (words.length > 1) {
                String firstWord = words[0];
                String lastWord = words[words.length - 1];

                words[0] = lastWord;
                words[words.length - 1] = firstWord;

                sentence = String.join(" ", words);
            }

            matcher.appendReplacement(result, sentence);
        }
        matcher.appendTail(result);

        // Выводим измененный текст
        System.out.println(result.toString());
    }
}
