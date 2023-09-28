/**
 * Виконання задачі 2.4 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t2_task_2_4 {
    public static int modifyBit(int n, int p, int b) {
        int mask = 1 << p;
        return ((n & ~mask) | (b << p));
    }

    public static int get_nth_value_bit(int n, int m) {
        return ((n >> (m-1)) & 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число n: ");
        int n = scanner.nextInt();

        System.out.print("Введіть номер біта m: ");
        int m = scanner.nextInt();

        System.out.println(modifyBit(n, m, get_nth_value_bit(n, m)));
    }
}
