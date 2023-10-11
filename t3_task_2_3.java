/**
 * Виконання задачі 2.3 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t3_task_2_3 {
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
        double[] val_in_row = new double[n];
        double[] max_val_in_row = new double[n];
        int counter = 0;
        int max_counter = 0;
        val_in_row[0] = matrix[0][0];
        max_val_in_row[0] = matrix[0][0];
        for (int i = 0; i < m; i++) {
            counter = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > matrix[i][j-1]) {
                    val_in_row[counter] = matrix[i][j-1];
                    counter += 1;
                    val_in_row[counter] = matrix[i][j];
                }
                else {
                    if (counter > max_counter) {
                        max_counter = counter;
                        max_val_in_row = val_in_row.clone();
                        counter = 0;
                    }
                }
            }
            if (counter > max_counter) {
                max_counter = counter;
                max_val_in_row = val_in_row.clone();
            }
        }
        System.out.print("Максимална послідовність = [");
        for (int i = 0; i < max_counter; i++) {
            System.out.print(max_val_in_row[i] + ", ");
        }
        System.out.print(max_val_in_row[max_counter] + "] з " + (max_counter + 1) + " символів");
    }
}
