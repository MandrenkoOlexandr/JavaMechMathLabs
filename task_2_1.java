/**
 * Виконання задачі 2.1
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class task_2_1 {
    public static void main(String[] args) {
        System.out.println("Введіть прізвище");
        Scanner sc = new Scanner(System.in);
        String surname = sc.nextLine();
        System.out.println("Привіт " + surname);
    }
}