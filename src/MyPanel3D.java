/**
 * Клас для графічної роботи з лабіринтом. Оснований на класі Graphics
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MyPanel3D extends JPanel {
    MyPanel3D() {this.setPreferredSize(new Dimension(2000, 1100));}

    public void paint(Graphics g) {
        Random rand = new Random();
        Graphics2D g2D = (Graphics2D) g;
        int n = 7;
        int m = 19;
        int l = 19;
        int[] start_p = new int[3];
        int[][][] maze_labyrinth = Labyrinths_3d.Labyrinths_generation_3d(n, m, l);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    if (maze_labyrinth[i][j][k] == 1) {
                        if (j - 1 >= 0) {
                            if (maze_labyrinth[i][j-1][k] == 1) {
                                g2D.drawLine(i * l * 12 + 12 * k + 6, 12 * j + 6, i * l * 12 + 12 * k + 6, 12 * j);
                            }
                        }
                        if (k - 1 >= 0) {
                            if (maze_labyrinth[i][j][k-1] == 1) {
                                g2D.drawLine(i * l * 12 + 12 * k + 6, 12 * j + 6, i * l * 12 + 12 * k, 12 * j + 6);
                            }
                        }
                        if (j + 1 <= m-1) {
                            if (maze_labyrinth[i][j+1][k] == 1) {
                                g2D.drawLine(i * l * 12 + 12 * k + 6, 12 * j + 6, i * l * 12 + 12 * k + 6, 12 * (j+1));
                            }
                        }
                        if (k + 1 <= l-1) {
                            if (maze_labyrinth[i][j][k+1] == 1) {
                                g2D.drawLine(i * l * 12 + 12 * k + 6, 12 * j + 6, i * l * 12 + 12 * (k+1), 12 * j + 6);
                            }
                        }
                    }
                    if (maze_labyrinth[i][j][k] == 0) {
                        if (i - 1 >= 0) {
                            if (maze_labyrinth[i-1][j][k] == 0) {
                                g2D.setColor(Color.blue);
                                g2D.drawOval(i * l * 12 + 12 * k + 2, 12 * j + 2, 8, 8);
                                g2D.setColor(Color.black);
                            }
                        }
                        if (i + 1 <= n-1) {
                            if (maze_labyrinth[i+1][j][k] == 0) {
                                g2D.setColor(Color.green);
                                g2D.drawOval(i * l * 12 + 12 * k - 2, 12 * j - 2, 16, 16);
                                g2D.setColor(Color.black);
                            }
                        }
                    }
                }
            }
        }
        g2D.setColor(Color.red);
        start_p = new int[]{rand.nextInt(0, maze_labyrinth.length),
                            rand.nextInt(0, maze_labyrinth[0].length),
                            rand.nextInt(0, maze_labyrinth[0][0].length)};
        while (maze_labyrinth[start_p[0]][start_p[1]][start_p[2]] == 1) {
            start_p = new int[]{rand.nextInt(0, maze_labyrinth.length),
                    rand.nextInt(0, maze_labyrinth[0].length),
                    rand.nextInt(0, maze_labyrinth[0][0].length)};
        }
        ArrayList<int[]> path = Labyrinths_3d.build_path(Labyrinths_3d.wave_algorithm(maze_labyrinth, start_p),
                Labyrinths_3d.find_esc(maze_labyrinth), start_p);
        for (int i = 0; i < path.size()-1; i++) {
            if (path.get(i)[0] == path.get(i+1)[0]) {
                g2D.drawLine(path.get(i)[0] * l * 12 + 12 * path.get(i)[2] + 6, 12 * path.get(i)[1] + 6,
                        path.get(i+1)[0] * l * 12 + 12 * path.get(i+1)[2] + 6, 12 * path.get(i+1)[1] + 6);
            }
            else {
                if (path.get(i)[0] > path.get(i+1)[0]) {
                    g2D.setColor(Color.blue);
                    g2D.drawLine(path.get(i+1)[0] * l * 12 + 12 * path.get(i+1)[2] + 6, 12 * path.get(i+1)[1] + 6,
                            path.get(i+1)[0] * l * 12 + 12 * path.get(i+1)[2] + 12, 12 * path.get(i+1)[1] + 6);
                    g2D.setColor(Color.red);
                }
                if (path.get(i)[0] < path.get(i+1)[0]) {
                    g2D.setColor(Color.green);
                    g2D.drawLine(path.get(i+1)[0] * l * 12 + 12 * path.get(i+1)[2] + 6, 12 * path.get(i+1)[1] + 6,
                            path.get(i+1)[0] * l * 12 + 12 * path.get(i+1)[2], 12 * path.get(i+1)[1] + 6);
                    g2D.setColor(Color.red);
                }
            }
        }
        g2D.fillOval(start_p[0] * l * 12 + 12 * start_p[2] + 3, 12 * start_p[1] + 3, 6, 6);
    }
}