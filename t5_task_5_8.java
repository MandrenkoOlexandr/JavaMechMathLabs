/**
 * Виконання задачі 5.8 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class t5_task_5_8 {
    public static void main(String[] args) {
        String inputFileName = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_in.txt";
        String outputFileName = "C:/Users/mandr/IdeaProjects/MechMathLabs/Task_12/src/file_out.txt";

        filterPositiveNumbers(inputFileName, outputFileName);

        System.out.println("Процедура завершена. Додатні числа записані у файл file_out.txt.");
    }

    private static void filterPositiveNumbers(String inputFileName, String outputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");

                for (String numberStr : numbers) {
                    try {
                        int number = Integer.parseInt(numberStr);
                        if (number > 0) {
                            writer.write(number + " ");
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

