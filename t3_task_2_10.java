/**
 * Виконання задачі 2.10 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t3_task_2_10 {
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
        double max_element = matrix[0][0];
        int[] list_of_row = new int[m];
        int[] list_of_col = new int[n];
        int index = 0;
        list_of_row[index] = 0;
        list_of_col[index] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == max_element) {
                    list_of_row[index] = i;
                    list_of_col[index] = j;
                    index += 1;
                }
                if (matrix[i][j] > max_element) {
                    max_element = matrix[i][j];
                    index = 0;
                    list_of_row[index] = i;
                    list_of_col[index] = j;
                    index += 1;
                }
            }
        }
        int N = n;
        int M = m;
        for (int i = 0; i < m; i++) {
            for (int x : list_of_row) {
                if (x == i) {
                    M -= 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int x : list_of_col) {
                if (x == i) {
                    N -= 1;
                    break;
                }
            }
        }
        double[][] new_matrix = new double[M][N];
        int ii = 0;
        int jj = 0;
        for (int i = 0; i < m; i++) {
            boolean foundi = false;
            for (int x : list_of_row) {
                if (x == i) {
                    foundi = true;
                    break;
                }
            }
            if (!foundi) {
                for (int j = 0; j < n; j++) {
                    boolean foundj = false;
                    for (int x : list_of_col) {
                        if (x == j) {
                            foundj = true;
                            break;
                        }
                    }
                    if (!foundj) {
                        new_matrix[ii][jj] = matrix[i][j];
                        jj += 1;
                    }
                }
                ii += 1;
                jj = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(new_matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
