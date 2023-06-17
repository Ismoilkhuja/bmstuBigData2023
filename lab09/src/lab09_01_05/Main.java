package lab09_01_05;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "apple", "banana");

        List<String> uniqueStrings = strings.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique strings: " + uniqueStrings);
    }
}
