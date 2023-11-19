/**
 * Виконання задачі 5.1 (4 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.ArrayList;
import java.util.List;

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}

class Sentence {
    private List<Word> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public List<Word> getWords() {
        return words;
    }
}

class Text {
    private List<Sentence> sentences;
    private String title;

    public Text(String title) {
        this.title = title;
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void printText() {
        System.out.println("Назва: " + title);
        for (Sentence sentence : sentences) {
            for (Word word : sentence.getWords()) {
                System.out.print(word.getWord() + " ");
            }
            System.out.println();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

public class t4_task_5_1 {
    public static void main(String[] args) {

        Word hello = new Word("Привіт");
        Word world = new Word("світ");
        Word example = new Word("приклад");


        Sentence sentence1 = new Sentence();
        sentence1.addWord(hello);
        sentence1.addWord(world);


        Sentence sentence2 = new Sentence();
        sentence2.addWord(example);


        Text text = new Text("Мій текст");
        text.addSentence(sentence1);
        text.addSentence(sentence2);


        text.printText();


        Word addedWord = new Word("додаємо");
        sentence2.addWord(addedWord);
        text.printText();


        text.setTitle("Доповнений текст");
        text.printText();
    }
}