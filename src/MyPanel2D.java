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

public class MyPanel2D extends JPanel {
    MyPanel2D(){
        this.setPreferredSize(new Dimension(2000, 1100));
    }
    public void paint(Graphics g) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        Graphics2D g2D = (Graphics2D) g;
        System.out.print("Введіть висоту лабіринта (до 63): ");
        int n = sc.nextInt();
        if (n % 2 == 0){n++;}
        System.out.print("Введіть ширину лабіринта (до 119): ");
        int m = sc.nextInt();
        if (m % 2 == 0){m++;}
        System.out.print("Виберіть варіант вводу стартової точки (0 якщо з консолі, 1 якщо випадкова генерація): ");
        int bol = sc.nextInt();
        int[] x_road = new int[]{-1, 0, 1, 0};
        int[] y_road = new int[]{0, 1, 0, -1};
        int[] start_p = new int[2];
        int[][] maze_labyrinth = Labyrinths_2d.Labyrinths_generation(n, m);
        if (bol == 0) {
            System.out.println("Введіть стартову точку (в межах лабіринту)");
            System.out.print("x: ");
            int x = sc.nextInt();
            System.out.print("y: ");
            int y = sc.nextInt();
            start_p = new int[]{x, y};
            if (maze_labyrinth[start_p[0]][start_p[1]] == 1) {
                int p = 1;
                for (int i = 0; i < 4; i++) {
                    start_p = new int[]{x + x_road[i], y + y_road[i]};
                    if (maze_labyrinth[start_p[0]][start_p[1]] == 0) {
                        p = 0;
                        break;
                    }
                }
                if (p == 1) {
                    start_p = new int[] {x+1, y+1};
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze_labyrinth[i][j] == 1) {
                    if (i - 1 >= 0) {
                        if (maze_labyrinth[i-1][j] == 1) {
                            g2D.drawLine(16 * j + 8, 16 * i + 8, 16 * j + 8, 16 * i);
                        }
                    }
                    if (j - 1 >= 0) {
                        if (maze_labyrinth[i][j-1] == 1) {
                            g2D.drawLine(16 * j + 8, 16 * i + 8, 16 * j, 16 * i + 8);
                        }
                    }
                    if (i + 1 <= n-1) {
                        if (maze_labyrinth[i+1][j] == 1) {
                            g2D.drawLine(16 * j + 8, 16 * i + 8, 16 * j + 8, 16 * (i+1));
                        }
                    }
                    if (j + 1 <= m-1) {
                        if (maze_labyrinth[i][j+1] == 1) {
                            g2D.drawLine(16 * j + 8, 16 * i + 8, 16 * (j+1), 16 * i + 8);
                        }
                    }
                }
            }
        }
        g2D.setColor(Color.red);
        if (bol != 0) {
            start_p = new int[]{rand.nextInt(0, maze_labyrinth.length),
                    rand.nextInt(0, maze_labyrinth[0].length)};
            while (maze_labyrinth[start_p[0]][start_p[1]] == 1) {
                start_p = new int[]{rand.nextInt(0, maze_labyrinth.length),
                        rand.nextInt(0, maze_labyrinth[0].length)};
            }
        }
        ArrayList<int[]> path = Labyrinths_2d.build_path(Labyrinths_2d.wave_algorithm(maze_labyrinth, start_p),
                Labyrinths_2d.find_esc(maze_labyrinth), start_p);
        for (int i = 0; i < path.size()-1; i++) {
            g2D.drawLine(16 * path.get(i)[1] + 8, 16 * path.get(i)[0] + 8,
                    16 * path.get(i+1)[1] + 8, 16 * path.get(i+1)[0] + 8);
        }
        g2D.fillOval(16 * start_p[1] + 4, 16 * start_p[0] + 4, 8, 8);
    }

}
