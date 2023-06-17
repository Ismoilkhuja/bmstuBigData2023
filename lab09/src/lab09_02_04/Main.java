package lab09_02_04;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        Map<Character, Character> map = strings.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s.charAt(1)));

        System.out.println("Map: " + map);
    }
}
