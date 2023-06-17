package lab05_04_04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String filePath = "students.txt";
//        File file = new File(filePath);

        // Создание новой директории
        String directoryPath = "results";
        File directory = new File(directoryPath);
        directory.mkdir();

        // Создание нового файла
        String filePath = directoryPath + File.separator + "students.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();

            // Запись фамилий студентов с оценками выше 7 в файл
            FileWriter writer = new FileWriter(file);
            writer.write("Иванов 8\n");
            writer.write("Петров 6\n");
            writer.write("Сидоров 9\n");
            writer.write("Смирнов 7\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            String tempFilePath = directoryPath + File.separator + "tmp.txt";
            File tempFile = new File(tempFilePath);

            // Запись фамилий студентов с оценками выше 7 во временный файл
            FileWriter writer = new FileWriter(tempFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String surname = parts[0];
                int grade = Integer.parseInt(parts[1]);

                if (grade > 7) {
                    writer.write(surname.toUpperCase() + " " + grade + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }

            scanner.close();
            writer.close();

            // Удаление исходного файла
            file.delete();

            // Переименование временного файла в исходное имя файла
            tempFile.renameTo(file);

            System.out.println("Фамилии студентов с оценками выше 7 записаны в файл " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
