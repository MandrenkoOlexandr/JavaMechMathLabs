/**
 * Виконання задачі 4.2 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t2_task_4_2 {
    public static void main(String[] args) {
        int[] Month_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day_of_the_week = 0;
        int Friday_13_counters = 0;
        int max_counter = 0;
        for (int i = 1; i <= 400; i++) {
            if (i % 4 == 0) {
                Month_days[1] = 29;
            }else{
                Month_days[1] = 28;
            }
            for (int j = 0; j <= 11; j++) {
                for (int k = 1; k <= Month_days[j]; k++) {
                    day_of_the_week++;
                    Friday_13_counters++;
                    if (day_of_the_week > 7) {day_of_the_week = 1;}
                    if (k == 13){
                        if (day_of_the_week == 5) {
                            if (Friday_13_counters-1 > max_counter) {
                                max_counter = Friday_13_counters-1;
                            }
                            Friday_13_counters = 0;
                        }
                    }
                }
            }
        }
        System.out.println("Максимальна кількість днів без п'ятниці 13-го = " + max_counter);
    }
}
