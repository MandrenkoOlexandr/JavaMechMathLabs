/**
 * Допоміжний клас для розміщення об'єкту дошка для малювання
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import javax.swing.*;

public class MyFrame2D extends JFrame {
    MyPanel2D panel;
    MyFrame2D(){
        panel = new MyPanel2D();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}