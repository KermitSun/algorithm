package kermit.algorithm.sort.monitor;

/**
 * @Author: Kermit
 * Description: TODO
 * Create by: 22:41 2019/4/23
 */
public class SortMonitorRange {
    public static int getRange(int size){
        if(in(size, 0, 8)){
            return 1;
        }else if(in(size, 8, 16)){
            return 2;
        }else if(in(size, 16, 32)){
            return 3;
        }else if(in(size, 32, 64)){
            return 4;
        }else if(in(size, 64, 128)){
            return 5;
        }else if(in(size, 128, 256)){
            return 6;
        }else{
            return 7;
        }
    }

    private static boolean in(int val, int left, int right){
        return (val >= left && val < right);
    }
}
