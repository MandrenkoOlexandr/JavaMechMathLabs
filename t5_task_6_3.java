/**
 * Виконання задачі 6.3 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.io.*;

public class t5_task_6_3 {
    public static void main(String[] args) {
        String inputFilePath = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_in.txt";
        String outputFilePath = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_out.txt";

        try {
            long product = 1;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0) {
                        product *= number;
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Добуток парних елементів: " + product);
            }

            System.out.println("Добуток парних елементів успішно записано в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
