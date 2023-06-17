package lab09_02_05;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "avocado");

        Map<Character, List<String>> groupedMap = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println("Grouped Map: " + groupedMap);
    }
}
