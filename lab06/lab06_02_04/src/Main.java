import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "input.txt";

        List<ObjectInfo> c1 = buildC1(inputFileName);
        System.out.println("Список C1 до сжатия:");
        printObjectList(c1);

        compressObjectList(c1);
        System.out.println("Список C1 после сжатия:");
        printObjectList(c1);
    }

    private static List<ObjectInfo> buildC1(String fileName) {
        List<ObjectInfo> c1 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Парсинг строки наименования и шифра объекта
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int code = Integer.parseInt(parts[1].trim());
                    ObjectInfo objectInfo = new ObjectInfo(name, code);
                    c1.add(objectInfo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Сортировка списка по возрастанию шифров
        Collections.sort(c1);

        return c1;
    }

    private static void compressObjectList(List<ObjectInfo> objectList) {
        Set<String> namesSet = new HashSet<>();
        List<ObjectInfo> compressedList = new ArrayList<>();

        for (ObjectInfo objectInfo : objectList) {
            if (!namesSet.contains(objectInfo.getName())) {
                compressedList.add(objectInfo);
                namesSet.add(objectInfo.getName());
            }
        }

        objectList.clear();
        objectList.addAll(compressedList);
    }

    private static void printObjectList(List<ObjectInfo> objectList) {
        for (ObjectInfo objectInfo : objectList) {
            System.out.println(objectInfo.getName() + " - " + objectInfo.getCode());
        }
    }

    private static class ObjectInfo implements Comparable<ObjectInfo> {
        private String name;
        private int code;

        public ObjectInfo(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }

        @Override
        public int compareTo(ObjectInfo other) {
            return Integer.compare(this.code, other.code);
        }
    }
}
