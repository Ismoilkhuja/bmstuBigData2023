import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInputFile {
    public static void main(String[] args) {
        String fileName = "input.txt";
        int objectCount = 10;

        generateInputFile(fileName, objectCount);
        System.out.println("Файл " + fileName + " сгенерирован.");
    }

    private static void generateInputFile(String fileName, int objectCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Random random = new Random();

            for (int i = 1; i <= objectCount; i++) {
                String name = "Object" + i;
                int code = random.nextInt(100) + 1; // случайный шифр от 1 до 100

                writer.write(name + ";" + code);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}