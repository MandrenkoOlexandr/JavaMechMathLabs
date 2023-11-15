package t4_task_1_4;

public class t4_task_1_4b {
    public static void main(String[] args) {
        t4_task_1_4a firstObject = new t4_task_1_4a();

        System.out.println("Original Protected Data: " + firstObject.protectedData);

        firstObject.manipulateProtectedData(100);

        System.out.println("Updated Protected Data: " + firstObject.protectedData);
    }
}
