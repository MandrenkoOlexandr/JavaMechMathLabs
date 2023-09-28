/**
 * Виконання задачі 3.5 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Arrays;

public class t2_task_3_5 {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Wrong input!");
        }
        else
        {

            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            int d = Integer.parseInt(args[3]);
            int e = Integer.parseInt(args[4]);

            int k[] = {a, b, c, d, e};
            Arrays.stream(k).sorted();
            System.out.println(k[2]);

        }
    }
}
