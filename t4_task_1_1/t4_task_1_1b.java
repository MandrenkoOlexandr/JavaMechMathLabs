package t4_task_1_1;

import t4_task_1_1.t4_task_1_1a.t4_task_1_1a;

public class t4_task_1_1b {
    public static void main(String[] args) {
        t4_task_1_1a myInstance = new t4_task_1_1a("Hello from outside the package");

        myInstance.displayMessage();
    }
}