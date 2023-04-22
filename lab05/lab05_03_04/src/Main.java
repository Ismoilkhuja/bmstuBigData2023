import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        if (args.length == 2) {
            inputFile = args[0];
            outputFile = args[1];
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
                String line = reader.readLine();
                inputFile = line.split("=")[1];
                line = reader.readLine();
                outputFile = line.split("=")[1];
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    if (word.length() != 0)
                        words.add(word);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.size() - 1; i++) {
            String currentWord = words.get(i);
            String nextWord = words.get(i + 1);
            if (currentWord.charAt(currentWord.length() - 1) == nextWord.charAt(0)) {
                result.add(currentWord);
            }
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            for (String word : result) {
                writer.write(word + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}