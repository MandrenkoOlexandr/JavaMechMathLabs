import java.util.Scanner;

/**
 * Виконання задачі 4.6 д)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class task_4_6_d {
    public static double gauss(double x) {
        return Math.exp(-Math.pow(x, 2));
    }
    public static double gauss_derivative(double x) {
        double delta_x = 0.000001;
        return (gauss(x + delta_x) - gauss(x)) / delta_x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть х: ");
        double x = sc.nextDouble();
        System.out.println("Значення функції = " + gauss(x));
        System.out.println("Похідна функції = " + gauss_derivative(x));
    }
}
