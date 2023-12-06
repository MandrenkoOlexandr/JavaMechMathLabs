/**
 * Виконання задачі 3.2 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Random;

public class t2_task_3_2 {
    public static void main(String[] args) {
        final Random random = new Random();
        int x = random.nextInt();
        for (int i = 1; i <= 25; i++) {
            int y = random.nextInt();
            if (y > x) {
                System.out.println("(" + i + ") " + "Згенероване значення y = " + y + " більше за x = " + x);
            }else{
                System.out.println("(" + i + ") " + "Згенероване значення y = " + y + " менше за x = " + x);
            }
        }
    }
}
