/**
 * Клас для генерації та роботи з 3д лабірнтами
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */


import java.util.*;

public class Labyrinths_3d {

    /**
     * Цей метод генерує випадковий 3д лабіринт та повертає його матрицю
     *
     * @param n Висота лабіринту
     * @param m Ширина лабіринту
     * @return Матриця лабіринту з нулів та одиниць, де одиниця це стіна, а 0 це прохід
     */
    public static int[][][] Labyrinths_generation_3d(int n, int m, int l) {
        int[][][] maze = new int[n][m][l];
        Random random = new Random();
        ArrayList<String> unvisited = new ArrayList<>();
        //Генеруємо та заповнюємо матрицю нулями на всіх непарних позиціях і одиницями на інших
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    if ((i % 2 != 0 && j % 2 != 0 && k % 2 != 0) && (i < n - 1 && j < m - 1 && k < l - 1)) {
                        maze[i][j][k] = 0;
                        unvisited.add(Arrays.toString((new int[]{i, j, k})));
                    } else {
                        maze[i][j][k] = 1;
                    }
                }
            }
        }
        int[] currentCell = new int[]{1, 1, 1};
        ArrayList<int[]> stack = new ArrayList<>();
        stack.add(currentCell);
        //Обираємо поточну точку і обираємо її сусіда видаляючи стінку між ними. Позначаємо точку як відвідану
        //Робимо це доти доки маємо невідвідані точки
        while (!unvisited.isEmpty()) {
            ArrayList<int[]> Neighbours = new ArrayList<>();
            if (unvisited.contains(Arrays.toString(new int[]{currentCell[0] - 2, currentCell[1], currentCell[2]}))) {
                Neighbours.add(new int[]{currentCell[0] - 2, currentCell[1], currentCell[2]});
            }
            if (unvisited.contains(Arrays.toString(new int[]{currentCell[0] + 2, currentCell[1], currentCell[2]}))) {
                Neighbours.add(new int[]{currentCell[0] + 2, currentCell[1], currentCell[2]});
            }
            if (unvisited.contains(Arrays.toString(new int[]{currentCell[0], currentCell[1] - 2, currentCell[2]}))) {
                Neighbours.add(new int[]{currentCell[0], currentCell[1] - 2, currentCell[2]});
            }
            if (unvisited.contains(Arrays.toString(new int[]{currentCell[0], currentCell[1] + 2, currentCell[2]}))) {
                Neighbours.add(new int[]{currentCell[0], currentCell[1] + 2, currentCell[2]});
            }
            if (unvisited.contains(Arrays.toString(new int[]{currentCell[0], currentCell[1], currentCell[2] - 2}))) {
                Neighbours.add(new int[]{currentCell[0], currentCell[1], currentCell[2] - 2});
            }
            if (unvisited.contains(Arrays.toString(new int[]{currentCell[0], currentCell[1], currentCell[2] + 2}))) {
                Neighbours.add(new int[]{currentCell[0], currentCell[1], currentCell[2] + 2});
            }
            // Якщо поточна точка має сусідів, обираємо випадкового і робимо його поточною точкою.
            // А попередню точку додаємо до стеку.
            if (!Neighbours.isEmpty()) {
                int[] cell = Neighbours.get(random.nextInt(0, Neighbours.size()));
                int diffx = cell[0] - currentCell[0];
                int diffy = cell[1] - currentCell[1];
                int diffz = cell[2] - currentCell[2];
                maze[currentCell[0] + diffx / 2][currentCell[1] + diffy / 2][currentCell[2] + diffz / 2] = 0;
                currentCell = cell;
                unvisited.remove(Arrays.toString(currentCell));
                stack.add(currentCell);
            }
            //Інакше вилучаємо точку зі стеку і повертаємось до попередньої точки стеку
            else {
                stack.remove(currentCell);
                currentCell = stack.get(stack.size() - 1);
            }
        }
        //Випадково генеруємо точку виходу на краях лабіринту
        int a = random.nextInt(0, 3);
        switch (a) {
            case 0 -> {
                if (random.nextInt(0, 2) == 0) {
                    int[] esc = new int[]{0, random.nextInt(1, m - 2), random.nextInt(1, l - 2)};
                    while (maze[1][esc[1]][esc[2]] == 1) {
                        esc = new int[]{0, random.nextInt(1, m - 2), random.nextInt(1, l - 2)};
                    }
                    maze[esc[0]][esc[1]][esc[2]] = 0;
                } else {
                    int[] esc = new int[]{n - 1, random.nextInt(1, m - 2), random.nextInt(1, l - 2)};
                    while (maze[n - 2][esc[1]][esc[2]] == 1) {
                        esc = new int[]{n - 1, random.nextInt(1, m - 2), random.nextInt(1, l - 2)};
                    }
                    maze[esc[0]][esc[1]][esc[2]] = 0;
                }
            }
            case 1 -> {
                if (random.nextInt(0, 2) == 0) {
                    int[] esc = new int[]{random.nextInt(1, n - 2), 0, random.nextInt(1, l - 2)};
                    while (maze[esc[0]][1][esc[2]] == 1) {
                        esc = new int[]{random.nextInt(1, n - 2), 0, random.nextInt(1, l - 2)};
                    }
                    maze[esc[0]][esc[1]][esc[2]] = 0;
                } else {
                    int[] esc = new int[]{random.nextInt(1, n - 2), m - 1, random.nextInt(1, l - 2)};
                    while (maze[esc[0]][m - 2][esc[2]] == 1) {
                        esc = new int[]{random.nextInt(1, n - 2), m - 1, random.nextInt(1, l - 2)};
                    }
                    maze[esc[0]][esc[1]][esc[2]] = 0;
                }
            }
            case 2 -> {
                if (random.nextInt(0, 2) == 0) {
                    int[] esc = new int[]{random.nextInt(1, n - 2), random.nextInt(1, m - 2), 0};
                    while (maze[esc[0]][esc[1]][1] == 1) {
                        esc = new int[]{random.nextInt(1, n - 2), random.nextInt(1, m - 2), 0};
                    }
                    maze[esc[0]][esc[1]][esc[2]] = 0;
                } else {
                    int[] esc = new int[]{random.nextInt(1, n - 2), random.nextInt(1, m - 2), l - 1};
                    while (maze[esc[0]][esc[1]][l - 2] == 1) {
                        esc = new int[]{random.nextInt(1, n - 2), random.nextInt(1, m - 2), l - 1};
                    }
                    maze[esc[0]][esc[1]][esc[2]] = 0;
                }
            }
        }
        return maze;
    }

    /**
     * Цей метод шукає точку виходу з лабіринту і повертає її
     *
     * @param matr Матриця лабіринту з 0 та 1
     * @return Точка виходу з лабіринту
     */
    public static int[] find_esc(int[][][] matr) {
        int[] esc = new int[3];
        boolean bol = true;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (matr[i][j][0] == 0) {
                    esc = new int[]{i, j, 0};
                    bol = false;
                    break;
                }
                if (matr[i][j][matr[0][0].length - 1] == 0) {
                    esc = new int[]{i, j, matr[0][0].length - 1};
                    bol = false;
                    break;
                }
            }
        }
        if (bol) {
            for (int i = 0; i < matr[0].length; i++) {
                for (int j = 0; j < matr[0][0].length; j++) {
                    if (matr[0][i][j] == 0) {
                        esc = new int[]{0, i, j};
                        break;
                    }
                    if (matr[matr.length - 1][i][j] == 0) {
                        esc = new int[]{matr.length - 1, i, j};
                        break;
                    }
                }
            }
        }
        if (bol) {
            for (int i = 0; i < matr.length; i++) {
                for (int j = 0; j < matr[0][0].length; j++) {
                    if (matr[i][0][j] == 0) {
                        esc = new int[]{i, 0, j};
                        break;
                    }
                    if (matr[i][matr[0].length - 1][j] == 0) {
                        esc = new int[]{i, matr[0].length - 1, j};
                        break;
                    }
                }
            }
        }
        return esc;
    }

    /**
     * Цей метод будує хвильову матрицю лабіринту, та вже по ній будує матрицю пошуку найкоротшого шляху
     *
     * @param maze_matrix Матриця лабіринту з нулів та одиниць
     * @param start_point Стартова точка лабіринту
     * @return Матриця пошуку
     */
    public static int[][][][] wave_algorithm(int[][][] maze_matrix, int[] start_point) {
        int[] dx = new int[]{-1, 0, 1, 0, 0, 0};
        int[] dy = new int[]{0, -1, 0, 1, 0, 0};
        int[] dz = new int[]{0, 0, 0, 0, -1, 1};
        int n = maze_matrix.length;
        int m = maze_matrix[0].length;
        int l = maze_matrix[0][0].length;
        int[][][] wave_matrix = new int[n][m][l];
        int[][][][] sources_matrix = new int[n][m][l][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    wave_matrix[i][j][k] = -1;
                }
            }
        }
        ArrayList<int[]> q = new ArrayList<>();
        q.add(start_point);
        wave_matrix[start_point[0]][start_point[1]][start_point[2]] = 0;
        while (!q.isEmpty()) {
            int[] current_point = q.get(0);
            q.remove(0);
            int i = current_point[0];
            int j = current_point[1];
            int k = current_point[2];
            for (int p = 0; p < dx.length; p++) {
                int i1 = i + dz[p];
                int j1 = j + dy[p];
                int k1 = k + dx[p];
                if (((0 <= i1) && (i1 < n)) && ((0 <= j1) && (j1 < m)) && ((0 <= k1) && (k1 < l))) {
                    if ((wave_matrix[i1][j1][k1] == -1) && (maze_matrix[i1][j1][k1] != 1)) {
                        q.add(new int[]{i1, j1, k1});
                        wave_matrix[i1][j1][k1] = wave_matrix[i][j][k] + 1;
                        sources_matrix[i1][j1][k1] = new int[]{i, j, k};
                    }
                }
            }
        }
        return sources_matrix;
    }

    /**
     * Цей метод будує найкоротший шлях до виходу з лабіринту
     *
     * @param sour    Матриця пошуку
     * @param exit_p  Точка виходу
     * @param start_p Точка початку
     * @return Список координат що є найкоротшим шляхом до виходу з лабіринту
     */
    public static ArrayList<int[]> build_path(int[][][][] sour, int[] exit_p, int[] start_p) {
        ArrayList<int[]> path = new ArrayList<>();
        int[] cur_pos = exit_p;
        while (!Arrays.equals(cur_pos, start_p)) {
            path.add(cur_pos);
            cur_pos = sour[cur_pos[0]][cur_pos[1]][cur_pos[2]];
        }
        path.add(start_p);
        return path;
    }

    public static void main(String[] args) {
        int[][][] Lab = Labyrinths_generation_3d(5, 9, 9);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    System.out.print(Lab[i][j][k] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        int[] esc = find_esc(Lab);
        System.out.println(Arrays.toString(esc));
        int[][][][] so = wave_algorithm(Lab, new int[]{1, 1, 1});
        ArrayList<int[]> pat = build_path(so, esc, new int[]{1, 1, 1});
        for (int i = 0; i < pat.size(); i++) {
            System.out.println(Arrays.toString(pat.get(i)));
        }
    }
}
