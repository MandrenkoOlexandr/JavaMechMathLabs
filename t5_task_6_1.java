/**
 * Виконання задачі 6.1 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.io.*;

public class t5_task_6_1 {

    public static void main(String[] args) {
        String inputFilePath = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_in.txt";
        String outputFilePath = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_out.txt";

        try {
            double sum = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    double number = Double.parseDouble(line);
                    sum += number;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Сума дійсних значень: " + sum);
            }

            System.out.println("Сума дійсних значень успішно записана в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
