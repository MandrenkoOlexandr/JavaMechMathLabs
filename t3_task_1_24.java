/**
 * Виконання задачі 1.24 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t3_task_1_24 {
    public static int recursive(int [] bag, int n, int w, int cur_w, int max_w, int cur_i){
        int maxw = max_w;
        for (int i = cur_i; i < n; i++) {
            maxw = recursive(bag, n, w, cur_w, max_w, cur_i + 1);
            if (bag[i] <= w) {
                cur_w += bag[i];
            }
            if (cur_w <= w) {
                if (cur_w >= max_w){
                    max_w = cur_w;
                    maxw = recursive(bag, n, w, cur_w, max_w, cur_i + 1);
                }
            }
        }
        return maxw;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int N = sc.nextInt();
        System.out.print("W = ");
        int W = sc.nextInt();
        int [] Bag = new int[N];
        for (int i = 0; i < N; i++) {
            Bag[i] = sc.nextInt();
        }
        int a = recursive(Bag, N, W, 0, 0, 0);
        System.out.print(a);
    }
}
