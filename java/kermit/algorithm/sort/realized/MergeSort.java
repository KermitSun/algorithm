package kermit.algorithm.sort.realized;

import java.util.List;

/**
 * @Date: 2019/4/2213:49
 * @Author: BoyuSun
 * @Description: 归并排序
 * 采用二分法，将数组拆分成最大为2的多个子数组，
 * 进行排序，然后将有序集合进行merge合并
 * 归并排序是很稳定的排序算法，但是其空间复杂度高，对大数据量的排序处理并不是很好
 *  最好时间复杂度：O(nlogn)
 *  最坏时间复杂度：O(nlogn)
 *  平均时间复杂度：O(nlogn)
 *  空间复杂度：O(n)非原地，但是新建的堆空间是O(nlogn)
 *  稳定性：稳定 相同数值不交换位置
 */
public class MergeSort implements Sort{
    @Override
    public <T> void sort(List<T> list, SortCompareLambda lambda) {
        checkEmpty(list);
        int len = list.size();
        this.lambda = lambda;
        recursion(list, 0, list.size()-1);
    }

    private SortCompareLambda lambda = null;
    /**
     * @Author: Kermit
     * @Description: 将一个list拆分重组
     * @Create by: 21:44 2019/5/5
     */
    private <T> void recursion(List<T> list, int leftIdx, int rightIdx){
        if(leftIdx == rightIdx){
            return;
        }
        if(rightIdx - leftIdx == 1){
            if(!lambda.operation(leftIdx, rightIdx)){
                swap(list, rightIdx, leftIdx);
            }
            return;
        }
        int mid = (leftIdx + rightIdx)/2;
        recursion(list, leftIdx, mid);
        recursion(list, mid+1, rightIdx);
        merge(list, leftIdx, mid, rightIdx, lambda);
    }

}
