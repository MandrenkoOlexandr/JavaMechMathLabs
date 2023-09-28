/**
 * Виконання задачі 2.6 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t2_task_2_6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int counter_11 = 0;
        char [] ch_a = Integer.toBinaryString(a).toCharArray();
        char [] x = Integer.toBinaryString(1).toCharArray();
        for(int i = 1; i < ch_a.length; i++) {
            if(ch_a[i] == x[0])
                if(ch_a[i-1] == x[0])
                    counter_11 += 1;
        }
        System.out.println(Integer.toBinaryString(a));
        System.out.println(counter_11);
    }
}
