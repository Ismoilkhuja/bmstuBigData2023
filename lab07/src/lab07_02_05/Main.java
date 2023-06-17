package lab07_02_05;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String poem = "The equicku brown afoxa\nJumps over the lazy dog\nAnd sings a melodious song.";
        String poem = "Я возвращался с охоты и шел по аллее сада. Собака бежала впереди меня.\n" +
                "Вдруг она уменьшила свои шаги и начала красться, как бы зачуяв перед собою дичь.\n" +
                "Я глянул вдоль аллеи и увидел молодого воробья с желтизной около клюва и пухом на голове. " +
                "Он упал из гнезда (ветер сильно качал березы аллеи) и сидел неподвижно, " +
                "беспомощно растопырив едва прораставшие крылышки.";

        // Подсчет слов, начинающихся и заканчивающихся гласной буквой
        int vowelWordsCount = countVowelWords(poem);
        System.out.println();
        System.out.println("Vowel Words Count: " + vowelWordsCount);
    }

    public static int countVowelWords(String text) {
        // Создаем регулярное выражение для поиска слов, начинающихся и заканчивающихся гласной буквой
        Pattern pattern = Pattern.compile("\\b[aeiouаяуюоеёэиы]\\w*[aeiouаяуюоеёэиы]\\b",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);


        // Подсчитываем количество совпадений
        int count = 0;
        while (matcher.find()) {
            // for debug
            // System.out.println(matcher.group());
            count++;
        }

        return count;
    }
}
