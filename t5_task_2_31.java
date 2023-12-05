/**
 * Виконання задачі 2.31 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;
import java.util.TreeSet;

public class t5_task_2_31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок: ");
        String inputString = scanner.nextLine().toLowerCase();
        TreeSet<Character> uniqueUkrainianLetters = getUniqueUkrainianLetters(inputString);

        System.out.println("Різні малі українські літери в алфавітному порядку:");
        for (char letter : uniqueUkrainianLetters) {
            System.out.print(letter + " ");
        }
    }

    private static TreeSet<Character> getUniqueUkrainianLetters(String inputString) {
        TreeSet<Character> ukrainianLettersSet = new TreeSet<>();

        for (char ch : inputString.toCharArray()) {
            if (Character.UnicodeScript.of(ch) == Character.UnicodeScript.CYRILLIC &&
                    Character.isLowerCase(ch)) {
                ukrainianLettersSet.add(ch);
            }
        }

        return ukrainianLettersSet;
    }
}

