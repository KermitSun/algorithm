package kermit.algorithm.sort;

/**
 * @Date: 2019/4/2211:38
 * @Author: BoyuSun
 * @Description: 监控排序方法的执行时间
 */
public class SortMonitoring {

    public static void getSupperMethod(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(stackTrace[0]);
        System.out.println(stackTrace[1]);
        System.out.println(stackTrace[2]);
    }
}
