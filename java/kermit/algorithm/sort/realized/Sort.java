package kermit.algorithm.sort.realized;

import kermit.algorithm.sort.monitor.SortMonitorIO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *@Date: 13:43 2019/4/22
 *@Description: 排序父接口
 */
public interface Sort{
    /**
     *@Date: 19:57 2019/5/5
     *@Description: 记录乱序值
     */
    ThreadLocal<Integer> sequentialNum = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    default <T> void sort(List<T> list, SortRule sr, int sortRuleType){
        //要求i<j，满足条件返回true
        SortCompareLambda lambda = (int i, int j) -> sr.getProperty(list.get(j)).compareTo(sr.getProperty(list.get(i))) != sortRuleType;
        sort(list, lambda);
    }

    default <T> void sort(List<T> list, Comparator comparator){
        //要求i<j，满足返回true
        SortCompareLambda lambda = (int i, int j) -> comparator.compare(list.get(i), list.get(j)) >= 0;
        sort(list, lambda);
    }
    <T> void sort(List<T> list, SortCompareLambda lambda);

    /**
     *@Date: 11:07 2019/4/22
     *@Description: 交换
     */
    default <T> void swap(List<T> list, int idx1, int idx2){
        if(idx1 == idx2)
            return;
        T o = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, o);
        //记录乱序值
        sequentialNum.set(sequentialNum.get()+1);
    }
    default <T> void swap(T[] arr, int idx1, int idx2){
        T o = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = arr[idx1];
        //记录乱序值
        sequentialNum.set(sequentialNum.get()+1);
    }

    /**
     *@Date: 19:22 2019/5/5
     *@Description: list中[list,boundary]与(boundary,right]两个有序集合比较并排序
     */
    default <T> void merge(List<T> list, int left, int boundary, int right, SortCompareLambda lambda){
        int idx1 = left;
        int idx2 = boundary+1;
        List<T> newList = new ArrayList(right-left);
        while(idx1 <= boundary && idx2 <= right){
            if(lambda.operation(idx1, idx2)){
                newList.add(list.get(idx1++));
            }else{
                newList.add(list.get(idx2++));
            }
        }

        if(newList.size() < (right-left+1)){
            if(idx1 < boundary){
                newList.addAll(list.subList(idx1, boundary+1));
            }else if(idx2 < right){
                newList.addAll(list.subList(idx2, right+1));
            }
        }
        for(int i=left,j=0;j<newList.size();i++,j++){
            list.set(i, newList.get(j));
        }
    }

    default void clearSequentialNum(){
        sequentialNum.set(0);
    }
    default Integer getSequentialNum(){
        return sequentialNum.get();
    }

    /**
     *@Date: 11:08 2019/4/22
     *@Description: 检查是否为空
     */
    default void checkEmpty(List list){
        if(list == null){
            throw new NullPointerException("参数不能为空");
        }
    }
}
