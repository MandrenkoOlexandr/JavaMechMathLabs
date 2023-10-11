/**
 * Виконання задачі 1.2 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;
import java.util.Arrays;

public class t3_task_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[100];
        int i = 0;
        int k = sc.nextInt();
        while (k != 0) {
            arr[i] = k;
            i++;
            k = sc.nextInt();
        }
        Arrays.sort(arr, 0, i);
        System.out.println(Arrays.toString(arr));
        System.out.println("Min = " + arr[0]);
        System.out.println("Max = " + arr[i-1]);
    }
}
