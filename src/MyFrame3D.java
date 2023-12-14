/**
 * Допоміжний клас для розміщення об'єкту дошка для малювання
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import javax.swing.*;

public class MyFrame3D extends JFrame {
    MyPanel3D panel;
    MyFrame3D(){
        panel = new MyPanel3D();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}