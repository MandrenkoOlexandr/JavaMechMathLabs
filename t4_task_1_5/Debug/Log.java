package t4_task_1_5.Debug;

public class Log {
    public static void log (String ...args){
        for (String s: args){
            System.out.print(s+",");
        }
    }
}
