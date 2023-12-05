/**
 * Виконання задачі 6.6 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class t5_task_6_6 {
    public static void main(String[] args) {
        String inputFileName = "F.txt";
        String outputFileName = "G.txt";
        String helperFileName = "H.txt";

        filterAdjacentNumbers(inputFileName, outputFileName, helperFileName);

        System.out.println("Процедура завершена. Результат записано у файл G.txt.");
    }

    private static void filterAdjacentNumbers(String inputFileName, String outputFileName, String helperFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
             BufferedWriter helperWriter = new BufferedWriter(new FileWriter(helperFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");

                for (int i = 0; i < numbers.length; i++) {
                    int currentNumber = Integer.parseInt(numbers[i]);

                    if (i == 0 || (i > 0 && currentNumber * Integer.parseInt(numbers[i - 1]) > 0)) {
                        writer.write(currentNumber + " ");
                    } else {
                        helperWriter.write(currentNumber + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
