/**
 * Виконання задачі 2.7 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t5_task_2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть натуральне число n: ");
        int n = scanner.nextInt();

        System.out.print("Введіть систему числення b: ");
        int b = scanner.nextInt();

        if (n < 0 || b <= 1) {
            System.out.println("Введіть коректні значення.");
        } else {
            System.out.println("Цілі числа від 0 до " + n + " в системі числення " + b + ":");

            for (int i = 0; i <= n; i++) {
                String numberInBase = convertToBase(i, b);
                System.out.println(i + " в " + b + "-й системі числення: " + numberInBase);
            }
        }
    }
    private static String convertToBase(int number, int base) {
        if (number == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            result.insert(0, remainder);
            number = number / base;
        }

        return result.toString();
    }
}
