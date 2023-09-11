/**
 * Виконання задачі 1.6
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class task_1_6 {
    public static void main(String[] args) {
        int x = 0;
        for (int i = 0; i < args.length; i++) {
            int y = Integer.parseInt(args[i]);
            x += y;
        }
        System.out.println(x);
    }
}
