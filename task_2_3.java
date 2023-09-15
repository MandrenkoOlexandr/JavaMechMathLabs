/**
 * Виконання задачі 2.3
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class task_2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть 2 будь-яких дійсних числа через пробіл: ");
        String st_num1 = sc.next();
        String st_num2 = sc.next();
        double num1 = Double.parseDouble(st_num1);
        double num2 = Double.parseDouble(st_num2);
        double geometric_mean = Math.sqrt(num1 * num2);
        System.out.println("Середнє геометричне в десятковому виді = " + geometric_mean);
        System.out.println("Середнє геометричне в науковому виді = " + String.format("%e",geometric_mean));
    }
}
