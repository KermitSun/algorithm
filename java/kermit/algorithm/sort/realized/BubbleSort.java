package kermit.algorithm.sort.realized;

import kermit.algorithm.sort.monitor.SortMonitor;
import kermit.algorithm.sort.monitor.SortMonitorIO;

import java.util.Comparator;
import java.util.List;

/**
 * @Author: Kermit
 * @Description: 冒泡排序
 * @Create by: 10:32 2019/4/6
 *  最好时间复杂度：O(n)
 *  最坏时间复杂度：O(n^2)=(1+n)/2*n=(n+n^2)/2
 *  平均时间复杂度：O(n^2)=(1+n)/4*n=(n+n^2)/4
 *  空间复杂度：O(1)原地
 *  稳定性：稳定 相同数值不交换
 */
public class BubbleSort implements Sort {
    @Override
    public <T> void sort(List<T> list, SortCompareLambda lambda) {
        checkEmpty(list);
        int len = list.size();
        for(int i=0;i<len;i++){
            boolean flag = true;
            for(int j=0;j<len-i-1;j++){
                if(lambda.operation(j+1,j)){
                    swap(list, j, j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
