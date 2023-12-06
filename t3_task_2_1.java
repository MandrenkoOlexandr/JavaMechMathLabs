/**
 * Виконання задачі 2.1 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Arrays;
import java.util.Scanner;

public class t3_task_2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        int m = in.nextInt();
        System.out.print("Enter the number of columns of the matrix: ");
        int n = in.nextInt();

        int[][] matr = new int[m][n];
        int[] arr = new int[n*m];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Input a[" + i + "][" + j + "] = ");
                int el = in.nextInt();
                matr[i][j] = el;
                arr[index] = el;
                index += 1;
            }
        }
        Arrays.sort(arr);
        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matr[i][j] = arr[index];
                index += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }
}