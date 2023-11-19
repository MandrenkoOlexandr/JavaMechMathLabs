/**
 * Виконання задачі 5.15 (4 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Arrays;
import java.util.Objects;

class Window {
    private boolean isOpen;

    public Window() {
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Window window = (Window) obj;
        return isOpen == window.isOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpen);
    }

    @Override
    public String toString() {
        return "Вікно{" + "відчинене = " + isOpen + '}';
    }
}

class Door {
    private boolean isOpen;

    public Door() {
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Door door = (Door) obj;
        return isOpen == door.isOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpen);
    }

    @Override
    public String toString() {
        return "Двері{" + "відчинені = " + isOpen + '}';
    }
}

class House {
    private Window[] windows;
    private Door[] doors;

    public House(int windowCount, int doorCount) {
        this.windows = new Window[windowCount];
        this.doors = new Door[doorCount];

        for (int i = 0; i < windowCount; i++) {
            windows[i] = new Window();
        }

        for (int i = 0; i < doorCount; i++) {
            doors[i] = new Door();
        }
    }

    public void closeAllDoorsAndWindows() {
        for (Window window : windows) {
            window.close();
        }

        for (Door door : doors) {
            door.close();
        }
    }

    public int getWindowCount() {
        return windows.length;
    }

    public int getDoorCount() {
        return doors.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        House house = (House) obj;
        return Arrays.equals(windows, house.windows) && Arrays.equals(doors, house.doors);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(windows);
        result = 31 * result + Arrays.hashCode(doors);
        return result;
    }

    @Override
    public String toString() {
        return "Будинок{" + "вікна = " + Arrays.toString(windows) + ", двері = " + Arrays.toString(doors) + '}';
    }
}

public class t4_task_5_15 {

    public static void main(String[] args) {
        House house = new House(5, 2);

        System.out.println("Початковий стан: ");
        System.out.println("Кількість вікон: " + house.getWindowCount());
        System.out.println("Кількість дверей: " + house.getDoorCount());
        System.out.println(house);

        System.out.println("\nЗакрити всі двері та вікна: ");
        house.closeAllDoorsAndWindows();
        System.out.println(house);
    }
}


