package t4_task_2_4;
import java.util.Arrays;

class Abiturient {
    int id;
    String lastName;
    String firstName;
    String middleName;
    String address;
    String phoneNumber;
    int[] grades;

    public Abiturient(int id, String lastName, String firstName, String middleName, String address, String phoneNumber, int[] grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.grades = grades;
    }
}

public class t4_task_2_4 {
    public static void main(String[] args) {
        Abiturient[] abiturients = {
                new Abiturient(1, "LastName1", "FirstName1", "MiddleName1", "Address1", "PhoneNumber1", new int[] {85, 90, 95}),
                new Abiturient(2, "LastName2", "FirstName2", "MiddleName2", "Address2", "PhoneNumber2", new int[] {70, 80, 65}),
                new Abiturient(3, "LastName3", "FirstName3", "MiddleName3", "Address3", "PhoneNumber3", new int[] {55, 60, 45}),
        };

        System.out.println("a) Список абітурієнтів із незадовільними оцінками:");
        for (Abiturient abiturient : abiturients) {
            if (hasUnsatisfactoryGrades(abiturient.grades)) {
                System.out.println(abiturient.lastName + " " + abiturient.firstName);
            }
        }

        System.out.println("b) Список абітурієнтів із сумою балів вище заданої:");
        int need_sum = 250;
        for (Abiturient abiturient : abiturients) {
            int sum = calculateTotalScore(abiturient.grades);
            if (sum > need_sum) {
                System.out.println(abiturient.lastName + " " + abiturient.firstName);
            }
        }

        System.out.println("c) Вибрати задане число абітурієнтів з найвищою сумою балів:");
        int ss = 2;
        selectTopAbiturients(abiturients, ss);
    }

    public static boolean hasUnsatisfactoryGrades(int[] grades) {
        for (int grade : grades) {
            if (grade < 60) {
                return true;
            }
        }
        return false;
    }

    public static int calculateTotalScore(int[] grades) {
        int sum=0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum;
    }

    public static void selectTopAbiturients(Abiturient[] abiturients, int k) {
        if (k > abiturients.length) {
            System.out.println("Запит на отримання більше абітурієнтів, ніж доступно в масиві.");
            return;
        }

        Arrays.sort(abiturients, (a1, a2) -> Integer.compare(calculateTotalScore(a2.grades), calculateTotalScore(a1.grades)));
        System.out.println("Топ-" + k + " абітурієнтів з найвищою сумою балів:");
        for (int i = 0; i < k; i++) {
            System.out.println(abiturients[i].lastName + " " + abiturients[i].firstName);
        }
    }
}
