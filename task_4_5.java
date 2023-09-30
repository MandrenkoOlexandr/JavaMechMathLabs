/**
 * Виконання задачі 4.5
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class task_4_5 {
    public static double dist_between_points(double ax, double ay, double bx, double by) {
        return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
    }
    public static double triangle_square(double A, double B, double C) {
        double p = (A + B + C) / 2;
        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть координати точки а через пробіл: ");
        String st_ax = sc.next();
        String st_ay = sc.next();
        double ax = Double.parseDouble(st_ax);
        double ay = Double.parseDouble(st_ay);
        System.out.print("\nВведіть координати точки b через пробіл: ");
        String st_bx = sc.next();
        String st_by = sc.next();
        double bx = Double.parseDouble(st_bx);
        double by = Double.parseDouble(st_by);
        System.out.print("\nВведіть координати точки c через пробіл: ");
        String st_cx = sc.next();
        String st_cy = sc.next();
        double cx = Double.parseDouble(st_cx);
        double cy = Double.parseDouble(st_cy);
        double A = dist_between_points(ax, ay, bx, by);
        double B = dist_between_points(bx, by, cx, cy);
        double C = dist_between_points(ax, ay, cx, cy);
        double square = triangle_square(A, B, C);
        System.out.println("\nПлоща трикутника = " + square);
    }
}
