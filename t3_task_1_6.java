/**
 * Виконання задачі 1.6 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t3_task_1_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        int[] arr_of_num = new int[n];
        System.out.println("elements: ");
        for (int i = 0; i < n; i++) {
            arr_of_num[i] = sc.nextInt();
        }
        int[] arr_of_min = new int[n];
        int count = 0;
        int min_value = String.valueOf(arr_of_num[0]).length();
        arr_of_min[count] = arr_of_num[0];
        count += 1;
        for (int i = 1; i < n; i++) {
            if (String.valueOf(arr_of_num[i]).length() == min_value) {
                arr_of_min[count] = arr_of_num[i];
                count += 1;
            }
            if (String.valueOf(arr_of_num[i]).length() < min_value) {
                count = 0;
                min_value = String.valueOf(arr_of_num[i]).length();
                arr_of_min[count] = arr_of_num[i];
                count += 1;
            }
        }
        System.out.print("min elements = ");
        for (int i = 0; i < count-1; i++) {
            System.out.print(arr_of_min[i] + ", ");
        }
        System.out.print(arr_of_min[count-1]);
    }
}
