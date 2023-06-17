import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "input.txt";

        List<Integer> c1 = new ArrayList<>();
        List<Integer> c2 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            boolean isC1 = true;

            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);

                if (number < 0) {
                    isC1 = false;
                    continue;
                }

                if (isC1) {
                    c1.add(number);
                } else {
                    c2.add(number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(c1);
        Collections.sort(c2);

        List<Integer> mergedList = mergeSortedLists(c1, c2);
        System.out.println("Упорядоченный объединенный список:");
        System.out.println(mergedList);
    }

    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);

            if (num1 < num2) {
                mergedList.add(num1);
                i++;
            } else {
                mergedList.add(num2);
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}
