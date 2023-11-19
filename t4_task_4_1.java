/**
 * Виконання задачі 4.1 (4 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.ArrayList;
import java.util.List;

public class t4_task_4_1 {
    public static void main(String[] args) {
        int n = 3;
        List<Polynomial> polynomials = new ArrayList<>();

        Polynomial poly1 = new Polynomial();
        poly1.addCoefficient(new Rat_Fraction(1, 2));
        poly1.addCoefficient(new Rat_Fraction(3, 4));
        poly1.addCoefficient(new Rat_Fraction(1, 3));
        polynomials.add(poly1);

        Polynomial poly2 = new Polynomial();
        poly2.addCoefficient(new Rat_Fraction(2, 1));
        poly2.addCoefficient(new Rat_Fraction(1, 2));
        polynomials.add(poly2);

        Polynomial poly3 = new Polynomial();
        poly3.addCoefficient(new Rat_Fraction(3, 5));
        poly3.addCoefficient(new Rat_Fraction(2, 3));
        poly3.addCoefficient(new Rat_Fraction(5, 6));
        polynomials.add(poly3);

        Polynomial sum = new Polynomial();
        for (Polynomial polynomial : polynomials) {
            for (int i = 0; i < polynomial.coefficients.size(); i++) {
                if (i >= sum.coefficients.size()) {
                    sum.coefficients.add(new Rat_Fraction(0, 1));
                }
                sum.coefficients.get(i).add(polynomial.coefficients.get(i));
            }
        }

        System.out.println("Сума многочленів:");
        for (int i = 0; i < sum.coefficients.size(); i++) {
            System.out.println("Коефіцієнти " + i + ": " + sum.coefficients.get(i));
        }
    }
}




class Rat_Fraction {
    int numerator;
    int denominator;

    public Rat_Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(Rat_Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.numerator = newNumerator;
        this.denominator = commonDenominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class Polynomial {
    List<Rat_Fraction> coefficients;

    public Polynomial() {
        coefficients = new ArrayList<>();
    }

    public void addCoefficient(Rat_Fraction coefficient) {
        coefficients.add(coefficient);
    }

    public Rat_Fraction evaluate(int x) {
        Rat_Fraction result = new Rat_Fraction(0, 1);

        for (int i = 0; i < coefficients.size(); i++) {
            Rat_Fraction term = coefficients.get(i);
            Rat_Fraction xTerm = new Rat_Fraction((int) Math.pow(x, i), 1);
            term.add(xTerm);
            result.add(term);
        }

        return result;
    }
}
