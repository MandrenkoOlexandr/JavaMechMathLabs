/**
 * Виконання задачі 2.20 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

import java.util.Scanner;

public class t2_task_2_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //int N = 2017;
        int NN = N;
        String ans = "";

        while (NN > 0)
        {
            String temp = (Integer.toString((NN%2)));
            NN /= 2;
            for (int i = 6; i > 0; i--)
            {
                temp = Integer.toString((NN%2)).concat(temp);
                NN /= 2;
            }
            ans = ans.concat(temp);
            ans = ans.concat(" ");
        }

        System.out.println(ans);
        scanner.close();
    }
}
