/**
 * Виконання задачі 1.1 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t3_task_1_1 {
    public static void main(String[] args) {
        String[] x;
        x = new String[] {"Apple", "Strawberry", "Banana", "Orange"};

        System.out.print("x = ");
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + ", ");
        }
        System.out.println(x[x.length - 1] + "\n");

        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}