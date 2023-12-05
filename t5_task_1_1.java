/**
 * Виконання задачі 1.1 (5 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t5_task_1_1 {
    public static void main(String[] args) {
        String text;

        if (args.length > 0) {
            text = String.join(" ", args);
        } else {
            text = "Це приклад тексту. Тут ми підраховуємо кількість слів.";
        }

        int wordCount = countWords(text);
        System.out.println("Кількість слів в тексті: " + wordCount);
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }
}