/**
 * Виконання задачі 3.4 (2 тема)
 *
 * @author Mandrenko Olexandr
 * @version 20.0.2
 */

public class t2_task_3_4 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Wrong input!");
        }
        else
        {

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);

            if (((x==y)||(y==z)||(z==x)) && !(x==y && y==z))
            {
                System.out.println("2");
            }
            else
            {
                if (x==y && y==z)
                {
                    System.out.println("1");
                }
                else
                {
                    System.out.println("3");
                }
            }
        }
    }
}
