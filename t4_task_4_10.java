/**
 * Виконання задачі 4.10 (4 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.ArrayList;
import java.util.List;

public class t4_task_4_10 {
    private double a;
    private double b;
    private double c;

    public t4_task_4_10(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Два дійсних корені: Корінь1 = " + root1 + ", Корінь2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Один дійсний корінь: Корінь = " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Комплексні корені: Корінь1 = " + realPart + " + " + imaginaryPart + "i, Корінь2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }

    public double[] getRoots() {
        double discriminant = b * b - 4 * a * c;
        double[] roots = new double[2];

        if (discriminant > 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            roots[0] = -b / (2 * a);
            roots[1] = roots[0];
        } else {
            roots[0] = Double.NaN;
            roots[1] = Double.NaN;
        }

        return roots;
    }

    public static class QuadraticInequality {
        private double a;
        private double b;
        private double c;
        private String inequality;

        public QuadraticInequality(double a, double b, double c, String inequality) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.inequality = inequality;
        }

        public boolean isSatisfied(double x) {
            double y = a * x * x + b * x + c;
            switch (inequality) {
                case "<":
                    return y < 0;
                case "<=":
                    return y <= 0;
                case ">":
                    return y > 0;
                case ">=":
                    return y >= 0;
                default:
                    return false;
            }
        }
    }

    public static void main(String[] args) {
        List<t4_task_4_10> equations = new ArrayList<>();

        equations.add(new t4_task_4_10(1, -3, 2));
        equations.add(new t4_task_4_10(1, 2, 1));
        equations.add(new t4_task_4_10(1, 0, -1));

        double smallestRoot = Double.POSITIVE_INFINITY;
        double largestRoot = Double.NEGATIVE_INFINITY;

        for (t4_task_4_10 equation : equations) {
            double[] roots = equation.getRoots();
            for (double root : roots) {
                if (!Double.isNaN(root)) {
                    smallestRoot = Math.min(smallestRoot, root);
                    largestRoot = Math.max(largestRoot, root);
                }
            }
        }

        System.out.println("Найменший корінь: " + smallestRoot);
        System.out.println("Найбільший корінь: " + largestRoot);


        List<QuadraticInequality> inequalities = new ArrayList<>();
        inequalities.add(new QuadraticInequality(1, -3, 2, ">="));
        inequalities.add(new QuadraticInequality(1, 2, 1, ">="));
        inequalities.add(new QuadraticInequality(1, 0, -1, "<="));

        for (QuadraticInequality inequality : inequalities) {
            List<String> validIntervals = new ArrayList<>();
            for (int x = -100; x <= 100; x++) {
                if (inequality.isSatisfied(x)) {
                    validIntervals.add(String.valueOf(x));
                    while (x <= 100 && inequality.isSatisfied(x)) {
                        x++;
                    }
                    validIntervals.add(String.valueOf(x - 1));
                }
            }

            System.out.println("Інтервали для " + inequality.inequality + " " + inequality.a + "x^2 + "
                    + inequality.b + "x + " + inequality.c + ": " + validIntervals);
        }
    }
}
