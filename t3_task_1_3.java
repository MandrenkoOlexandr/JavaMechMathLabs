/**
 * Виконання задачі 1.3 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t3_task_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n = ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        System.out.println("Input elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        double sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
        }
        double mean = sum1 / n;
        double sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += (arr[i] - mean) * (arr[i] - mean);
        }
        double deviation = Math.sqrt(sum2 / (n - 1));
        System.out.println("Mean = " + mean);
        System.out.println("Sample standard deviation = " + deviation);
    }
}
