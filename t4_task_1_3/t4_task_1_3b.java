package t4_task_1_3;

public class t4_task_1_3b {
    public static void main(String[] args) {
        t4_task_1_3a testObject = new t4_task_1_3a();

        System.out.println("Public field: " + testObject.publicField);
        testObject.publicMethod();

        System.out.println("Protected field: " + testObject.protectedField);
        testObject.protectedMethod();
        System.out.println("Package access field: " + testObject.packageAccessField);
        testObject.packageAccessMethod();
    }
}
