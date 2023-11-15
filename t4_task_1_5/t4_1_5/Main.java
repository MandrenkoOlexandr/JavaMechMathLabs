package t4_task_1_5.t4_1_5;

import java.util.Scanner;
import t4_task_1_5.t4_1_5_rect.rect;
import static t4_task_1_5.Debugoff.Log.log;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        rect r = new rect();
        r.input(sc);
        System.out.println(r);
        sc.close();
        System.out.println(r);
        Debug.Log.log(String.valueOf(r.area()));

    }
}