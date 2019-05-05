package kermit.algorithm.sort.realized;

import java.util.Comparator;
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

    }

    private <T> void recursion(List<T> list, int startIdx, int endIdx, SortCompareLambda lambda){
       /* int diff = endIdx-startIdx;
        if(diff == 1){
            if(endIdx>startIdx && lambda.operation(endIdx, startIdx)){
                swap(list, endIdx, startIdx);
            }
            return;
        }else if(diff == 0){
            return;
        }
        int mid = (startIdx + endIdx)/2;
        recursion(list, startIdx, mid, lambda);
        recursion(list, mid+1, endIdx, lambda);

        swap(list, startIdx, mid, endIdx, lambda);*/
    }

}
