/**
 * Виконання задачі 2.3 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t2_task_2_3 {
    public static void main(String[] args) {
        char c = 'A';
        String binaryString = Integer.toBinaryString(c);

        while (binaryString.length() < 8) {
            binaryString = "0" + binaryString;
        }

        System.out.println(binaryString);
    }
}
