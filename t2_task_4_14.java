/**
 * Виконання задачі 4.14 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;


public class t2_task_4_14 {
    public static void main(String[] args) {
        System.out.println("Маємо систему:\nA1x + B1y = C1\nA2x + B2y = C2");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть А1 В1 С1 через пробіл: ");
        String A1s = sc.next();
        String B1s = sc.next();
        String C1s = sc.next();
        double A1 = Double.parseDouble(A1s);
        double B1 = Double.parseDouble(B1s);
        double C1 = Double.parseDouble(C1s);
        System.out.println("Введіть А2 В2 С2 через пробіл: ");
        String A2s = sc.next();
        String B2s = sc.next();
        String C2s = sc.next();
        double A2 = Double.parseDouble(A2s);
        double B2 = Double.parseDouble(B2s);
        double C2 = Double.parseDouble(C2s);
        double eps = 0.00000000000000000000000000001;
        if (B1 < eps) {
            double x = C1 / A1;
            double y = (C2 - A2*x)/B2;
            System.out.println("Розв'язок рівняння\nx = " + x + "\ny = " + y);
        }
        if (B2 < eps) {
            double x = C2 / A2;
            double y = (C1 - A1*x)/B1;
            System.out.println("Розв'язок рівняння\nx = " + x + "\ny = " + y);
        }
        if (B1 > eps & B2 > eps){
            double x = (C1 - B1*(C2/B2)) / (A1 - B1*(A2/B2));
            double y = (C1 - A1*x)/B1;
            System.out.println("Розв'язок рівняння\nx = " + x + "\ny = " + y);
        }
    }
}
