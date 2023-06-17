package lab05_04_05;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание новой директории
        String directoryPath = "results";
        File directory = new File(directoryPath);
        directory.mkdir();

        // Создание нового файла
        String filePath = directoryPath + File.separator + "data.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();

            // Запись данных в файл
            FileWriter writer = new FileWriter(file);
            writer.write("abc 123\n");
            writer.write("def 456\n");
            writer.write("ghi 7.89\n");
            writer.write("jkl 10.5\n");
            writer.close();

            // Чтение файла и определение данных заданного типа
            Scanner scanner = new Scanner(file);

            Scanner console_scanner = new Scanner(System.in);

            System.out.print("Введите тип данных (char, String, int, float): ");
            String dataType = console_scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String data = parts[1];

                if (isDataType(data, dataType)) {
                    System.out.println(data);
                }
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isDataType(String data, String dataType) {
        switch (dataType) {
            case "char":
                return data.length() == 1;
            case "String":
                return true;
            case "int":
                try {
                    Integer.parseInt(data);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            case "float":
                try {
                    Float.parseFloat(data);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            default:
                return false;
        }
    }
}
