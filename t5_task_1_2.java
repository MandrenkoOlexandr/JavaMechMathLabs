/**
 * Виконання задачі 1.2 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t5_task_1_2 {
    public static void main(String[] args) {
        String text;

        if (args.length > 0) {
            text = String.join(" ", args);
        } else {
            text = "Це приклад тексту для обернення.";
        }

        String reversedText = reverseText(text);
        System.out.println("Обернений текст: " + reversedText);
    }

    private static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
