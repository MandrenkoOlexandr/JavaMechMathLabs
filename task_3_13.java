/**
 * Виконання задачі 3.13
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class task_3_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть дійсне число від 0 до 10000: ");
        double num = sc.nextDouble();
        double power = Math.pow(num, 8);
        System.out.printf(String.format("%.4f", power));
    }
}
