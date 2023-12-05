/**
 * Виконання задачі 1.5 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t5_task_1_5 {
    static public void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine()
                .replace("small", "very small")
                .replace("large", "very large");
        System.out.println(str);
    }
}
