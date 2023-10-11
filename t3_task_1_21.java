/**
 * Виконання задачі 1.21 (3 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t3_task_1_21 {
    public static void main(String[] args) {
        char[] ch_arr = args[0].toCharArray();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(ch_arr[i]) * (10 - i);
        }
        int control_num = 0;
        for (int i = 0; i < 11; i++) {
            if ((sum + i) % 11 == 0) {
                control_num = i;
            }
        }
        System.out.print(Character.getNumericValue(ch_arr[0]) + "-");
        for (int i = 1; i < 4; i++) {
            System.out.print(Character.getNumericValue(ch_arr[i]));
        }
        System.out.print("-");
        for (int i = 4; i < 9; i++) {
            System.out.print(Character.getNumericValue(ch_arr[i]));
        }
        System.out.print("-" + control_num);
    }
}
