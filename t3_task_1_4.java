/**
 * Виконання задачі 1.4 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;
import java.util.Arrays;

public class t3_task_1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        int[] arr_of_numbers = new int[n];

        System.out.println("elements: ");
        for (int i = 0; i < n; i++) {
            arr_of_numbers[i] = sc.nextInt();
        }
        int max_counts_in_row = 1;
        int max_number = arr_of_numbers[0];
        int counts_in_row = 1;
        int number = arr_of_numbers[0];
        for (int i = 1; i < n; i++) {
            if (arr_of_numbers[i] == arr_of_numbers[i-1]){
                number = arr_of_numbers[i];
                counts_in_row += 1;
            }
            else {
                if (counts_in_row > max_counts_in_row){
                    max_counts_in_row = counts_in_row;
                    max_number = number;
                }
                if (counts_in_row == max_counts_in_row){
                    if (number > max_number) {
                        max_number = number;
                    }
                }
                counts_in_row = 1;
            }
        }
        System.out.println(max_counts_in_row + " підряд чисел " + max_number);
    }
}
