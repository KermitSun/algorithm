package kermit.algorithm.sort.realized;

import java.util.List;

/**
 * @Date: 2019/4/2213:49
 * @Author: BoyuSun
 * @Description: 归并排序
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
