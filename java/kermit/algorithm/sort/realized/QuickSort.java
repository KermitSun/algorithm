package kermit.algorithm.sort.realized;

import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019/4/2213:50
 * @Author: BoyuSun
 * @Description: 快速排序
 * 在list中找到一个切分点，将小于切分点的放在左/右
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
        checkEmpty(list);
        this.lambda = lambda;
        partition(list, 0, list.size()-1);
    }

    /**
     * @Author: Kermit
     * @Description: 递归
     * @Create by: 23:09 2019/5/5
     */
    private void partition(List list, int leftIdx, int rightIdx){
        if(leftIdx >= rightIdx)
            return;
        int pivot = split(list, leftIdx, rightIdx);
        partition(list, leftIdx, pivot-1);
        partition(list, pivot+1, rightIdx);
    }

    /**
     *@Date: 16:32 2019/5/6
     *@Description: 获取分割点下标，然后以分割点为中心，
     * 把数据分割成大于和小于的两部分，返回分割点的下标
     */
    private int split(List list, int leftIdx, int rightIdx){
        int pivot = getPivot(list, leftIdx, rightIdx);
        //将切分点置为最右
        if(rightIdx != pivot)
            swap(list, rightIdx, pivot);
        pivot = leftIdx;

        //i为比较值的下标，minRangeRightLimit为分割点左侧的值得最后一个
        for(int i=leftIdx;i<rightIdx;i++){
            //如果当前数值与切分点比较不符合排序规则
            if(!lambda.operation(rightIdx, i)){
                swap(list, i, pivot);
                pivot++;
            }
        }
        swap(list, pivot, rightIdx);
        return pivot;
    }

    /**
     *@Date: 16:29 2019/5/6
     *@Description: 获取分割点，取样法，取三个值，选择中间的那个
     */
    //获取切分点下标,并分区
    private int getPivot(List list, int leftIdx, int rightIdx){
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
