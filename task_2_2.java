/**
 * Виконання задачі 2.2
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class task_2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Введіть 2 будь-яких цілих числа: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        System.out.println("Логарифмічний метод пошуку розрядів:");

        double log_num1 = Math.log10(number1);
        double log_num2 = Math.log10(number2);
        double lg_digit1 = Math.floor(log_num1);
        double lg_digit2 = Math.floor(log_num2);
        int lg_dg1 = (int) lg_digit1;
        int lg_dg2 = (int) lg_digit2;
        System.out.println("Розряд першого числа = " + lg_dg1 + ". Розряд другого числа = " + lg_dg2);

        System.out.println("Метод пошуку розряду за допомогою рядків:");

        String str1 = Integer.toString(number1);
        String str2 = Integer.toString(number2);
        int st_dg1 = str1.length() - 1;
        int st_dg2 = str2.length() - 1;
        System.out.println("Розряд першого числа = " + st_dg1 + ". Розряд другого числа = " + st_dg2);

        System.out.println("Пошук середнього гармонійного:");

        double garmonik_midl = (double) 2 / (((double) 1 / number1) + ((double) 1 / number2));
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Середнє гармонійне цих чисел = " + df.format(garmonik_midl));
    }
}
