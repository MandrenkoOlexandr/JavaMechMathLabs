/**
 * Виконання задачі 6.2 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.io.*;

public class t5_task_6_2 {

    public static void main(String[] args) {
        String inputFilePath = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_in.txt";
        String outputFilePath = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_out.txt";

        try {
            double product = 1.0;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    double number = Double.parseDouble(line);
                    if (number != 0) {
                        product *= Math.abs(number);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Добуток модулів ненульових елементів: " + product);
            }

            System.out.println("Добуток модулів ненульових елементів успішно записано в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
