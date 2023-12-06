/**
 * Виконання задачі 2.4 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t3_task_2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns of the matrix: ");
        int n = sc.nextInt();
        double[][] matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Input a[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextInt();
            }
        }
        double sum = 0;
        double[] indik = {-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    if (indik[0] == -1) {
                        indik[0] = matrix[i][j];
                    }
                    else {
                        indik[1] = matrix[i][j];
                    }
                }
                else {
                    if (indik[0] != -1) {
                        if (indik[1] == -1) {
                            sum += matrix[i][j];
                        }
                    }
                }
            }
            indik[0] = -1;
            indik[1] = -1;
        }
        System.out.print("Sum of this elements = " + sum);
    }
}
