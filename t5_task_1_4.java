/**
 * Виконання задачі 1.4 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t5_task_1_4 {
    static public void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine()
                .replace("an", "")
                .replace("a", "");
        System.out.println(str);
    }
}
