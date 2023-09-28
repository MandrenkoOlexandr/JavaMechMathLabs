/**
 * Виконання задачі 2.2 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t2_task_2_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        a = a << 1;
        while (a > 0)
        {
            a = a >> 1;
            System.out.println(Integer.toBinaryString(a));
        }
    }
}
