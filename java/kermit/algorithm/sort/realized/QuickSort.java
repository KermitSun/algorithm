package kermit.algorithm.sort.realized;

import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019/4/2213:50
 * @Author: BoyuSun
 * @Description: 快速排序
 *  最好时间复杂度：O()
 *  最坏时间复杂度：O()
 *  平均时间复杂度：O(nlogn)
 *  空间复杂度：
 *  稳定性：
 */
public class QuickSort implements Sort{
    private SortCompareLambda lambda;
    @Override
    public <T> void sort(List<T> list, SortCompareLambda lambda) {

    }

    /**
     * @Author: Kermit
     * @Description: 获取分割点，取样法，取三个值，选择中间的那个
     * @Create by: 23:09 2019/5/5
     */
    private int partition(List list, int leftIdx, int rightIdx){
        int mid = (leftIdx+rightIdx)/2;
        Integer[] arr = {leftIdx, mid, rightIdx};
        if(!lambda.operation(arr[0],arr[1])){
            swap(arr,0,1);
        }
        if(!lambda.operation(arr[1],arr[2])){
            swap(arr,1,2);
            if(!lambda.operation(arr[0],arr[1])){
                swap(arr,0,1);
            }
        }
        return arr[1];
    }
}
