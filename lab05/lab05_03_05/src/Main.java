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
        ArrayList<Integer> counts = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                int count = 0;
                int tmp = 0;
                for (int i = 0; i < line.length(); i++) {

                    if (Character.isDigit(line.charAt(i))){
                        tmp++;
                    } else {
                        if (tmp > count)
                            count = tmp;
                        tmp = 0;
                    }
                }
                counts.add(count);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            for (int count : counts) {
                writer.write(count + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}