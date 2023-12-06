/**
 * Виконання задачі 3.6 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Random;

public class t2_task_3_6 {
    public static void main(String[] args) {
        Random random = new Random();


        int a = 0;
        int b = 0;
        int t = 10000;
        for (int i = 0; i < t; i++) {
            boolean current = random.nextBoolean();
            boolean prev = false;
            int j = 0;
            for (j = 1; !(current && prev); j++) {
                prev = current;
                current = random.nextBoolean();
            }


            boolean current_b = random.nextBoolean();
            ;
            boolean prev_b = false;

            int k = 0;
            for (k = 1; !(!(current_b) && prev_b); k++) {
                prev_b = current_b;
                current_b = random.nextBoolean();
            }

            if (j < k) {
                a++;
            }
            if (j > k) {
                b++;
            }
        }
        System.out.println(((float) a) / t);
        System.out.println(39. / 121);
    }
}
